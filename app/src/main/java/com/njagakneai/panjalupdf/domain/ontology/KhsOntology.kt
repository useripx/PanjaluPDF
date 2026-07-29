package com.njagakneai.panjalupdf.domain.ontology

/**
 * Representasi Ontologi untuk Kartu Hasil Studi (KHS).
 * Dirancang khusus berdasarkan struktur KHS Universitas Nusantara PGRI Kediri.
 */
data class KhsDocument(
    val studentName: String,
    val npm: String,
    val studyProgram: String,
    val semester: String,
    val academicYear: String,
    val courses: List<CourseGrade>,
    val totalSks: Int,
    val gpa: Double // Indeks Prestasi
)

/**
 * Representasi Ontologi untuk satu baris mata kuliah pada tabel KHS.
 */
data class CourseGrade(
    val no: Int,
    val code: String,
    val name: String,
    val credit: Int,       // K (SKS)
    val gradeLetter: String, // Nh (Nilai Huruf)
    val gradeWeight: Double  // KxNn (Mutu)
) {
    /**
     * Fungsi Self-Correction (Validasi Logika): 
     * Mengembalikan true jika hasil OCR mutu (gradeWeight) sudah sesuai dengan 
     * perhitungan matematika SKS x Bobot Huruf.
     */
    fun isMathematicallyValid(expectedWeight: Double): Boolean {
        // Toleransi perbedaan presisi desimal kecil (misal: 9.9 vs 9.900000001)
        return Math.abs(this.gradeWeight - expectedWeight) < 0.01
    }
}
