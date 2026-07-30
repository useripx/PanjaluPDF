# Fase 4: Selesai! (Fitur Ekspor KHS)

Seluruh rancangan di `next.pdf` untuk Fase 4 telah berhasil diimplementasikan sepenuhnya. Aplikasi kini memiliki kemampuan untuk mengekspor data hasil bacaan (OCR) dari KHS menjadi file *native*.

## 🛠️ Perubahan yang Dilakukan

Saya telah membuat sebuah *engine* pengekspor khusus dan memodifikasi antarmuka di layar Preview:

### 1. `KhsExporter.kt` (Engine Ekspor)
Membuat utilitas baru yang berisi dua sistem cetak cerdas:
- **`exportToCsvString`**: Menulis data mahasiswa dan tabel mata kuliah menggunakan `StringBuilder` menjadi format CSV (Comma Separated Values) murni. Metode ini sangat ringan, tidak membebani HP sama sekali, dan 100% terbaca rapi saat dibuka di Microsoft Excel.
- **`exportToPdf`**: Memanfaatkan *library* `iText7` (yang sudah ada di proyek Anda) untuk menggambar tabel KHS secara rapi ke dalam dokumen PDF, lengkap dengan _header_ dan rangkuman nilai total.

### 2. `PreviewKhsScreen.kt` (Perubahan UI)
- Mengganti satu tombol "Ekspor Excel" yang sebelumnya statis (belum berfungsi) menjadi **dua tombol interaktif**: `[Simpan PDF]` dan `[Simpan CSV]`.
- Menerapkan **Android Storage Access Framework (SAF)** (menggunakan `ActivityResultContracts.CreateDocument`). Artinya, ketika tombol ditekan, aplikasi akan memunculkan laci sistem Android (layar "Save As") sehingga pengguna bebas memilih di folder mana file CSV atau PDF tersebut akan disimpan.
- Menambahkan notifikasi sukses/gagal di layar setelah penyimpanan selesai.

## 🚀 Cara Mengujinya

1. Jalankan aplikasi (tekan tombol Run di Android Studio).
2. Masuk ke fitur **Pindai Dokumen & Ekstrak**, lalu lakukan pindaian pada sebuah dokumen KHS (atau masuk ke layar Preview dengan data *dummy*).
3. Di bagian bawah layar, Anda sekarang akan melihat tombol **Simpan PDF** dan **Simpan CSV**.
4. Klik salah satu tombol tersebut. Anda akan diminta untuk menyimpan file (Android akan otomatis menyarankan nama, misalnya `KHS_2313020004_YogiArioPratama.csv`).
5. Cek file tersebut di File Manager HP Anda. Coba buka file CSV dengan Excel, atau buka file PDF dengan pembaca PDF. Semuanya akan tercetak dengan rapi!
