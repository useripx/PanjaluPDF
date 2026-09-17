# Panjalu PDF 🚀

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge)
![Hilt](https://img.shields.io/badge/Dagger_Hilt-2C2255?style=for-the-badge)
![Room Database](https://img.shields.io/badge/Room_Database-4CAF50?style=for-the-badge)
![Clean Architecture](https://img.shields.io/badge/Clean_Architecture-1D1D1D?style=for-the-badge)

Panjalu PDF adalah aplikasi manajemen dan pemindai dokumen berbasis Android yang canggih dan ringan, dirancang menggunakan standar *Modern Android Development* (MAD). Aplikasi ini hadir untuk menyederhanakan proses digitalisasi dokumen secara aman melalui pemrosesan dan penyimpanan lokal yang efisien.

## ✨ Fitur Utama (Berdasarkan Roadmap)

* **Manajemen Dokumen Cerdas:** Kelola, cari, dan kategorikan dokumen PDF serta Gambar dalam hitungan detik. 
* **Live Scan Kamera:** Pemindai dokumen cerdas yang langsung memotong (crop) tepi kertas dan merapikan halaman dokumen.
* **Editing Gambar Pro:** Optimalkan pencerahan, kontras, dan terapkan filter abu-abu/B&W untuk PDF yang sempurna.
* **Konverter Universal:** Ubah berbagai format gambar/foto ke dokumen PDF yang siap dibagikan.
* **Penyimpanan Lokal Super Cepat:** Sepenuhnya aman tanpa transmisi cloud, menggunakan Room Database yang efisien di latar belakang.

## 🛠 Teknologi & Arsitektur

Proyek ini menjunjung tinggi kestabilan aplikasi, keterbacaan kode, dan pemisahan lapisan (separation of concerns):
* **Bahasa:** [Kotlin](https://kotlinlang.org/) (Ver 2.2.x)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) dipadukan dengan standar **Material 3**.
* **Arsitektur:** **Clean Architecture** (Domain, Data, UI) & pola **MVI/MVVM** untuk _State Management_ layar.
* **Dependency Injection:** [Dagger Hilt](https://dagger.dev/hilt/)
* **Penyimpanan Lokal:** [Room Database](https://developer.android.com/training/data-storage/room) & Kotlin Serialization (KSP)
* **Asynchronous Execution:** Kotlin Coroutines & Flow API
* **Lingkungan Sistem:** Minimum SDK 29 (Android 10) | Target SDK 36 | AGP 9.3.2

## 📦 Struktur Proyek

Proyek Android ini dibagi ke dalam struktur lapisan yang rapi:
- `app/` : Berisi kode asli Android Kotlin. Logika inti terbagi lagi dalam _package_: `domain`, `data`, `di`, `ui`.
- `docs/` : Berisi _Roadmap_, panduan _Implementation Plan_, *Error Logs*, dan `progress_log.md` dari seluruh tahap (*Milestone*).
- `template/` : Berisi prototipe antarmuka dasar berbasis HTML/CSS statis sebagai visual patokan antarmuka (UI).

## 🚀 Instalasi (Lingkungan Development)

1. Pastikan sistem Anda memiliki versi terbaru **Android Studio** yang dapat menjalankan AGP versi 9+.
2. Lakukan _clone_ pada repository GitHub ini:
   ```bash
   git clone https://github.com/useripx/PanjaluPDF.git
   ```
3. Buka proyek hasil cloning melalui IDE Android Studio Anda.
4. Lakukan **Sync Project with Gradle Files**.
   > **Catatan Kompatibilitas:** Jika mendapati error _Android BaseExtension not found_ (isu versi dengan Hilt), biarkan `android.newDsl=false` tetap aktif di file `gradle.properties`. Plugin ini otomatis menekan pengaturan _built-in_ Kotlin dari AGP.
5. Bangun (Build) & eksekusi pada Emulator / perangkat (min SDK 29).

## 🤝 Alur Kerja (Workflow) Kolaborasi

Proses _development_ dilakukan dengan mengikuti gaya _Git Branching_ yang rapi:
* **Branch `main`:** Hanya menyimpan baris kode yang siap pakai (production-ready). Tidak boleh melakukan commit/push langsung oleh _agent_ manapun.
* **Branch `develop`:** Branch integrasi penyatuan kode.
* **Branch Pekerjaan (`sprint/...`, `feature/...`, `fix/...`):** Agen atau pengembang harus membuat cabang mandiri setiap kali ingin membuat komponen baru.

---
**Dirancang dan diprogram dengan ❤️ sebagai alat produktivitas unggul.**
