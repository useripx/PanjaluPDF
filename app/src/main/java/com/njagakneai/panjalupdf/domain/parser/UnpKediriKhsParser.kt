package com.njagakneai.panjalupdf.domain.parser

import com.njagakneai.panjalupdf.domain.ontology.CourseGrade
import com.njagakneai.panjalupdf.domain.ontology.KhsDocument

class UnpKediriKhsParser {

    /**
     * Memetakan nilai huruf ke bobot numerik sesuai standar Universitas Nusantara PGRI Kediri.
     */
    private fun getGradeWeight(gradeLetter: String): Double {
        return when (gradeLetter.uppercase().trim()) {
            "A" -> 4.0
            "A-" -> 3.7
            "B+" -> 3.3
            "B" -> 3.0
            "B-" -> 2.7
            "C+" -> 2.3
            "C" -> 2.0
            "D" -> 1.0
            "E" -> 0.0
            else -> 0.0
        }
    }

    /**
     * Fungsi utama untuk mengekstrak teks mentah hasil OCR menjadi struktur Ontologi KHS.
     */
    fun parse(rawText: String): KhsDocument {
        val lines = rawText.lines().map { it.trim() }.filter { it.isNotEmpty() }

        var studentName = ""
        var npm = ""
        var studyProgram = ""
        var semester = ""
        var academicYear = ""
        var totalSks = 0
        var gpa = 0.0
        val courses = mutableListOf<CourseGrade>()

        // Regex Patterns
        val nameRegex = Regex("""Nama\s*:\s*(.+)""", RegexOption.IGNORE_CASE)
        val npmRegex = Regex("""NPM\s*:\s*(\d+)""", RegexOption.IGNORE_CASE)
        val prodiRegex = Regex("""Prodi\s*:\s*(.+)""", RegexOption.IGNORE_CASE)
        val semesterRegex = Regex("""Semester\s*:\s*(.+)""", RegexOption.IGNORE_CASE)
        val yearRegex = Regex("""Thn Akademik\s*:\s*(.+)""", RegexOption.IGNORE_CASE)
        val totalSksRegex = Regex("""Total SKS\s*:\s*(\d+)""", RegexOption.IGNORE_CASE)
        val gpaRegex = Regex("""Indeks Prestasi\s*:\s*(\d+[,.]\d+)""", RegexOption.IGNORE_CASE)
        
        // Pattern baris tabel: No Kode NamaMatkul SKS NilaiHuruf Mutu
        // Contoh: 1 TIF1019 Desain dan Animasi 3 A 12
        val tableRowRegex = Regex("""^(\d+)\s+([A-Z0-9]+)\s+(.+?)\s+(\d+)\s+([A-E][+-]?)\s+(\d+(?:[.,]\d+)?)$""", RegexOption.IGNORE_CASE)

        for (line in lines) {
            // Parsing Header
            nameRegex.find(line)?.let { studentName = it.groupValues[1].trim() }
            npmRegex.find(line)?.let { npm = it.groupValues[1].trim() }
            prodiRegex.find(line)?.let { studyProgram = it.groupValues[1].trim() }
            semesterRegex.find(line)?.let { semester = it.groupValues[1].trim() }
            yearRegex.find(line)?.let { academicYear = it.groupValues[1].trim() }

            // Parsing Footer
            totalSksRegex.find(line)?.let { totalSks = it.groupValues[1].toIntOrNull() ?: 0 }
            gpaRegex.find(line)?.let { 
                val gpaString = it.groupValues[1].replace(",", ".")
                gpa = gpaString.toDoubleOrNull() ?: 0.0 
            }

            // Parsing Tabel
            val match = tableRowRegex.find(line)
            if (match != null) {
                val no = match.groupValues[1].toIntOrNull() ?: 0
                val code = match.groupValues[2]
                val name = match.groupValues[3]
                val sks = match.groupValues[4].toIntOrNull() ?: 0
                val gradeLetter = match.groupValues[5].uppercase()
                val gradeWeightString = match.groupValues[6].replace(",", ".")
                val gradeWeightOcr = gradeWeightString.toDoubleOrNull() ?: 0.0

                // Lapisan Validasi Logika (Self-Correction Layer)
                // Mutu harusnya = SKS * Bobot(Huruf)
                val expectedWeight = sks * getGradeWeight(gradeLetter)
                
                var finalGradeWeight = gradeWeightOcr
                // Jika OCR salah baca Mutu (contoh OCR baca 1Z bukan 12)
                // Kita percayakan hasil perkalian matematika di atas OCR
                if (Math.abs(gradeWeightOcr - expectedWeight) > 0.01) {
                    finalGradeWeight = expectedWeight
                }

                courses.add(
                    CourseGrade(
                        no = no,
                        code = code,
                        name = name.trim(),
                        credit = sks,
                        gradeLetter = gradeLetter,
                        gradeWeight = finalGradeWeight
                    )
                )
            }
        }

        // Cross-validation tingkat dokumen
        val calculatedTotalSks = courses.sumOf { it.credit }
        val finalTotalSks = if (totalSks == 0) calculatedTotalSks else totalSks

        return KhsDocument(
            studentName = studentName,
            npm = npm,
            studyProgram = studyProgram,
            semester = semester,
            academicYear = academicYear,
            courses = courses,
            totalSks = finalTotalSks,
            gpa = gpa
        )
    }
}
