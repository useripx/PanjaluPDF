package com.njagakneai.velapdf.utils

import android.content.Context
import android.net.Uri
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.properties.TextAlignment
import com.itextpdf.layout.properties.UnitValue
import com.njagakneai.velapdf.domain.ontology.KhsDocument
import java.io.OutputStream

object KhsExporter {

    /**
     * Converts a KhsDocument into a CSV formatted string.
     */
    fun exportToCsvString(khs: KhsDocument): String {
        val builder = StringBuilder()
        
        // CSV Header Block
        builder.append("KARTU HASIL STUDI (KHS)\n")
        builder.append("Nama,${escapeCsv(khs.studentName)}\n")
        builder.append("NPM,${escapeCsv(khs.npm)}\n")
        builder.append("Prodi,${escapeCsv(khs.studyProgram)}\n")
        builder.append("Semester,${escapeCsv(khs.semester)} - ${escapeCsv(khs.academicYear)}\n")
        builder.append("\n") // Blank line before table
        
        // Table Headers
        builder.append("No,Kode,Mata Kuliah,SKS,Nilai,Mutu\n")
        
        // Table Data
        khs.courses.forEach { course ->
            builder.append("${course.no},")
            builder.append("${escapeCsv(course.code)},")
            builder.append("${escapeCsv(course.name)},")
            builder.append("${course.credit},")
            builder.append("${escapeCsv(course.gradeLetter)},")
            builder.append("${course.gradeWeight}\n")
        }
        
        // Footer
        builder.append("\n")
        builder.append("Total SKS,${khs.totalSks}\n")
        builder.append("Indeks Prestasi,${khs.gpa}\n")
        
        return builder.toString()
    }

    private fun escapeCsv(value: String): String {
        var escaped = value
        if (escaped.contains(",") || escaped.contains("\"") || escaped.contains("\n")) {
            escaped = escaped.replace("\"", "\"\"")
            return "\"$escaped\""
        }
        return escaped
    }

    /**
     * Generates a PDF file from a KhsDocument and writes it to the provided output stream.
     */
    fun exportToPdf(khs: KhsDocument, outputStream: OutputStream) {
        val pdfWriter = PdfWriter(outputStream)
        val pdfDocument = PdfDocument(pdfWriter)
        val document = Document(pdfDocument)

        try {
            // Title
            val title = Paragraph("KARTU HASIL STUDI (KHS)")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setFontSize(16f)
                .setMarginBottom(20f)
            document.add(title)

            // Student Info
            document.add(Paragraph("Nama: ${khs.studentName}").setMarginBottom(0f))
            document.add(Paragraph("NPM: ${khs.npm}").setMarginBottom(0f))
            document.add(Paragraph("Program Studi: ${khs.studyProgram}").setMarginBottom(0f))
            document.add(Paragraph("Semester: ${khs.semester} - ${khs.academicYear}").setMarginBottom(20f))

            // Table
            val columnWidths = floatArrayOf(1f, 2f, 5f, 1f, 1f, 1.5f)
            val table = Table(UnitValue.createPercentArray(columnWidths))
                .useAllAvailableWidth()
                .setMarginBottom(20f)

            // Table Header
            val headers = listOf("No", "Kode", "Mata Kuliah", "SKS", "Nilai", "Mutu")
            for (header in headers) {
                val cell = Cell().add(Paragraph(header).setBold())
                    .setTextAlignment(TextAlignment.CENTER)
                table.addHeaderCell(cell)
            }

            // Table Body
            for (course in khs.courses) {
                table.addCell(Cell().add(Paragraph(course.no.toString())).setTextAlignment(TextAlignment.CENTER))
                table.addCell(Cell().add(Paragraph(course.code)))
                table.addCell(Cell().add(Paragraph(course.name)))
                table.addCell(Cell().add(Paragraph(course.credit.toString())).setTextAlignment(TextAlignment.CENTER))
                table.addCell(Cell().add(Paragraph(course.gradeLetter)).setTextAlignment(TextAlignment.CENTER))
                table.addCell(Cell().add(Paragraph(course.gradeWeight.toString())).setTextAlignment(TextAlignment.CENTER))
            }
            document.add(table)

            // Summary Footer
            document.add(Paragraph("Total SKS: ${khs.totalSks}").setBold())
            document.add(Paragraph("Indeks Prestasi (IP): ${khs.gpa}").setBold())
            
        } finally {
            document.close() // This closes the PdfDocument and the OutputStream automatically
        }
    }
}
