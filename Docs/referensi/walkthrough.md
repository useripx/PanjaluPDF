# Dokumentasi Perubahan: Fitur Ekstraksi Kartu Hasil Studi (KHS)

Dokumen ini mencatat seluruh riwayat perubahan arsitektural dan penulisan kode yang telah dilakukan pada aplikasi VelaPDF untuk mengimplementasikan fitur pemindaian dan ekstraksi data dari Kartu Hasil Studi (KHS).

## 1. Perencanaan dan Pendefinisian Standar
- **Kajian Format:** Menganalisis contoh dokumen referensi (`KHS1.pdf`) yang merupakan format asli dari Universitas Nusantara PGRI Kediri.
- **Standar Nilai:** Mengonversi tabel penilaian dari dokumen `nilai.md` menjadi bobot numerik sistem (Contoh: A = 4.0, A- = 3.7, B+ = 3.3, B = 3.0, B- = 2.7, C+ = 2.3, C = 2.0, D = 1.0, E = 0.0).
- **Arsitektur:** Mengadopsi pendekatan *Hybrid AI*, yang menggabungkan *Machine Learning* untuk OCR (Google ML Kit) dan *Rule-Based System* (Ontologi berbasis Kotlin) untuk pemahaman teks.

## 2. Pembuatan Lapisan Backend (AI & Ontology)
Lapisan ini dibuat di dalam package `domain` agar terpisah secara bersih (*clean architecture*) dari antarmuka pengguna:
- **`KhsOntology.kt`**: 
  Membuat *Data Classes* utama (`KhsDocument` dan `CourseGrade`) untuk memetakan data mahasiswa dan daftar nilai. Di dalam `CourseGrade`, kami menanamkan algoritma validasi (*Self-Correction*) yang dapat memeriksa kebenaran hasil pembacaan OCR secara matematis berdasarkan kalkulasi `SKS x Bobot Huruf`.
- **`UnpKediriKhsParser.kt`**: 
  Membuat *parser* bertenaga *Regular Expression* (Regex) yang dirancang khusus untuk membedah (*parsing*) teks KHS format UNP Kediri. Parser ini membagi pembacaan menjadi tiga segmen: Header (Nama, NPM), Baris Tabel, dan Footer (Total SKS, IP).

## 3. Integrasi Antarmuka Pengguna (UI)
Seluruh lapisan UI dibuat menggunakan Jetpack Compose:
- **`DashboardScreen.kt`**: 
  - Mengganti deskripsi dan ikon pada menu lama menjadi **"Pindai Dokumen & Ekstrak"**.
  - Mengintegrasikan fungsi klik pada menu tersebut ke **Google ML Kit Document Scanner** (`GmsDocumentScanning`). Pembaruan ini memungkinkan kamera pintar Android terbuka langsung dan menawarkan fitur pengenalan pinggiran dokumen serta opsi untuk memilih gambar KHS dari galeri (*Gallery Import Allowed*).
  - Mengaktifkan fungsi klik pada kartu **"Preview Hasil & Cetak"**.
- **`PreviewKhsScreen.kt`**: 
  Membuat halaman baru yang bertugas menampilkan hasil ekstraksi dari AI secara visual. Halaman ini mensimulasikan hasil bacaan mentah dari *dummy text*, mengumpankannya ke `UnpKediriKhsParser`, lalu me-render hasilnya menjadi format tabel yang indah (Header informasi, Tabel SKS & Mutu, dan Rekapitulasi).
- **`NavGraph.kt`**: 
  Memperbarui skema navigasi utama dengan menambahkan `Screen.PreviewKhs` agar halaman Preview yang baru dibuat dapat diakses melalui fungsi *routing* di Compose.

---
*Dokumen ini diperbarui secara otomatis selama proses pengembangan fitur.*
