# Rencana Struktur & Konten Website "Tentang Kami" - VelaPDF

Dokumen ini berisi rancangan lengkap struktur halaman dan konten untuk website promosi/informasi **VelaPDF** (A Modern PDF Toolkit for Android). Implementasi website akan dibagi berdasarkan halaman (atau bagian/fase navigasi utama).

---

## 🏠 Fase 1: Halaman Beranda (Home / Dashboard)
Halaman utama ini adalah hal pertama yang dilihat pengunjung. Tujuannya adalah memberikan kesan pertama yang kuat dan menjelaskan secara singkat apa itu VelaPDF.

**Isi Halaman & Komponen:**
1. **Navigasi (Navbar):**
   - Logo VelaPDF.
   - Menu Link: *Home*, *Features*, *Tech Stack*, *Our Team*, *Docs*.
   - Tombol: *Star on GitHub*.
2. **Hero Section (Bagian Atas):**
   - **Headline:** "VelaPDF - A Modern PDF Toolkit for Android"
   - **Sub-headline:** "Aplikasi Android modern untuk melihat, mengedit, dan mengelola dokumen PDF Anda dengan pengalaman pengguna yang mulus."
   - **Tombol Aksi (CTA):** `Unduh Aplikasi` dan `Lihat Source Code`.
   - **Visual:** Mockup / Gambar HP yang menampilkan tampilan antarmuka aplikasi VelaPDF.
3. **Sorotan (Highlights):**
   - Tampilan badge (Open Source, Android Platform, Jetpack Compose).

---

## ✨ Fase 2: Halaman / Bagian Fitur Utama (Features)
Fase ini menjabarkan kemampuan utama aplikasi VelaPDF kepada pengguna.

**Isi Halaman & Komponen:**
1. **Judul Bagian:** "Fitur Unggulan VelaPDF"
2. **Grid Fitur (Cards):**
   - 📖 **PDF Viewer:** "Lihat dokumen PDF dengan *rendering* yang mulus dan cepat."
   - 🖼️ **Image to PDF:** "Konversi gambar Anda menjadi format PDF dengan mudah."
   - 📝 **PDF Editor:** "Kemampuan *editing* dasar untuk dokumen PDF Anda."
   - 🔄 **File Converter:** "Konversi file dokumen antar berbagai format."
   - 🗂️ **File Manager:** "Kelola dan atur file PDF Anda dalam satu tempat terpusat."
   - 🌙 **Dark Mode:** "Dukungan tema gelap yang indah dan nyaman di mata."

---

## 🛠️ Fase 3: Halaman / Bagian Teknologi (Tech Stack & Architecture)
Halaman ini ditujukan untuk para *developer* atau kontributor yang tertarik dengan teknologi di balik VelaPDF.

**Isi Halaman & Komponen:**
1. **Arsitektur Proyek:**
   - Penjelasan bahwa VelaPDF menggunakan pola arsitektur **MVVM (Model-View-ViewModel)** dengan pemisahan *clean architecture*.
   - Visualisasi struktur folder (`data`, `di`, `domain`, `ui`, `utils`).
2. **Teknologi yang Digunakan (Tech Stack Grid):**
   - **Kotlin (2.0+)** - Bahasa pemrograman utama.
   - **Jetpack Compose** - Toolkit UI Modern.
   - **Material Design 3** - Sistem desain antarmuka.
   - **Firebase Auth & Credential Manager** - Autentikasi via Google Sign-In.
   - **iText7 Core** - Mesin pemroses PDF.
   - **Gradle KTS** - Sistem *build*.

---

## 👥 Fase 4: Halaman Tim Pengembang (Our Team)
Halaman ini didedikasikan untuk menampilkan orang-orang hebat di balik pengembangan VelaPDF.

**Isi Halaman & Komponen:**
1. **Judul Bagian:** "Kenali Tim Kami"
2. **Profil Anggota Tim (Profile Cards):** Menampilkan nama/username, foto profil/avatar, dan tautan ke GitHub masing-masing.
   - **useripx** ([GitHub](https://github.com/useripx))
   - **zenoszaiys** ([GitHub](https://github.com/zenoszaiys))
   - **giovan97** ([GitHub](https://github.com/giovan97))
   - **nazira** ([GitHub](https://github.com/NaziraWahdhani))

---

## 📚 Fase 5: Halaman Panduan & Dokumentasi (Getting Started)
Bagian ini berisi instruksi bagi pengguna atau pengembang lain yang ingin mencoba menjalankan proyek ini di komputer mereka sendiri.

**Isi Halaman & Komponen:**
1. **Prasyarat (Requirements):**
   - Android Studio Hedgehog (2023.1.1)+
   - JDK 17+
   - Android SDK API 24+
2. **Langkah-Langkah Instalasi (Tutorial Block):**
   - Format berbentuk urutan langkah (*Step-by-step*):
     - *Step 1:* Clone repository dari GitHub (`git clone https://github.com/velapdfdev/velapdfbeta`).
     - *Step 2:* Buka proyek di Android Studio dan tunggu sinkronisasi Gradle.
     - *Step 3:* Setup Firebase (menambahkan file `google-services.json` dan registrasi SHA-1).
     - *Step 4:* *Run* aplikasi di Emulator atau *Device* fisik.
3. **Bagian Kontribusi (Contributing):**
   - Penjelasan cara melakukan *Fork*, *Commit*, dan *Pull Request*.

---

## 🔽 Fase 6: Footer (Bagian Bawah Website)
Penutup halaman website.

**Isi Komponen:**
- Tautan repositori GitHub.
- Informasi Lisensi (MIT License).
- Teks penutup: "Made with ❤️ using Kotlin & Jetpack Compose"
- Copyright © VelaPDF Team.

