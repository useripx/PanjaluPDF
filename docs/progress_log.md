# Log Progres Pengembangan Panjalu PDF (v3)

## Status Saat Ini (17 September 2026)
**Fase yang Sedang Berjalan:** Milestone 1 (M1) - UI Layer & Foundation

### 1. Yang Telah Diselesaikan
* **Backend Dasar (Data & Domain Layer) Selesai:**
  * Setup Hilt, Room, KSP.
  * Pembuatan `PanjaluDatabase`, `DocumentDao`, `DocumentEntity`, `Converters`.
  * Pembuatan `DocumentRepository` dan `RepositoryModule` (diperbaiki karena sebelumnya tidak ter-*commit*).
* **Persiapan UI & Navigasi (Branch `feature/ui-foundation`):**
  * **Design Tokens:** Palet warna *Aeris Authority* (`Color.kt`) & tipografi (`Type.kt`).
  * **Splash Screen & Navigasi:** `SplashScreen.kt` & `NavGraph.kt`.
  * **Arsitektur MVI untuk Home:** `HomeState`, `HomeEvent`, dan `HomeViewModel` (dengan `@HiltViewModel`).
* **Perbaikan Isu Build Kritis & KSP (BERHASIL):**
  * **compileSdk 37:** Berhasil diperbarui untuk mendukung `androidx.lifecycle` terbaru.
  * **KSP `STAR null` Error:** Berhasil diatasi dengan memperbarui Hilt ke `2.56.2` dan menambahkan dependensi `kotlinx-serialization-json` yang sebelumnya tertinggal.
  * **Room `Continuation` Signature Mismatch:** Berhasil diatasi dengan menghapus `suspend` pada DAO (karena *bug* kompatibilitas Room 2.6.1 dengan Kotlin 2) dan membungkus pemanggilan DAO dengan `withContext(Dispatchers.IO)` di level *Repository*.
  * **Build `assembleDebug` sekarang berhasil tanpa kendala (SUCCESS).**

### 2. Apa yang Perlu Dilakukan Selanjutnya (Handoff)
* **Pengujian Manual (Run App):** Berhubung aplikasi sudah sukses di-*build*, buka Android Studio secara mandiri dan *Run* aplikasinya di emulator atau _device_ Android. Pastikan aplikasi berjalan (Splash screen tampil 3 detik, lalu masuk ke halaman utama).
* **Selesaikan UI Home (Milestone 1):** *HomeScreen* saat ini masih kerangka dasar. Implementasikan desain UI secara utuh untuk *list* dokumen, tombol tambah, dan pencarian sesuai panduan `template/`.
* **Merge ke Sprint Branch:** Jika desain UI berjalan lancar, *Merge* dari branch `feature/ui-foundation` ke `sprint/1-backend`, lalu kita siap masuk ke **Milestone 2 (M2 - Kamera & Scanner)**.

### 3. Catatan Khusus untuk Developer / Agent Berikutnya
* **PENTING (Versi AGP & Plugin Kotlin):** Menggunakan AGP versi baru (`9.3.2`). **JANGAN** pernah menambahkan `id("org.jetbrains.kotlin.android")` secara eksplisit pada block `plugins {}` di `app/build.gradle.kts`.
* **Kompabilitas Hilt & AGP 9:** Tetap pertahankan `android.newDsl=false` dan `android.disallowKotlinSourceSets=false` di `gradle.properties`.
* **Room KSP 2:** Fungsi Room di DAO **TIDAK BOLEH** menggunakan tipe `suspend` secara langsung kecuali ada jaminan versi Room >= 2.7.0. Lakukan *offloading thread* di level *Repository* seperti implementasi yang ada sekarang.
