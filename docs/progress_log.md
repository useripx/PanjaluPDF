# Log Progres Pengembangan Panjalu PDF (v2)

## Status Saat Ini (17 September 2026)
**Fase yang Sedang Berjalan:** Milestone 1 (M1) - UI Layer & Foundation

### 1. Yang Telah Diselesaikan
* **Backend Dasar (Data & Domain Layer) Selesai:**
  * Setup Hilt, Room, KSP.
  * Pembuatan `PanjaluDatabase`, `DocumentDao`, `DocumentEntity`, `Converters`.
  * Pembuatan `DocumentRepository` dan `RepositoryModule` untuk *Dependency Injection*.
* **Persiapan UI & Navigasi (Branch `feature/ui-foundation`):**
  * **Design Tokens:** Menerapkan palet warna *Aeris Authority* ke `Color.kt` dan mengatur gaya tipografi (Hanken Grotesk & Inter *fallbacks*) di `Type.kt`.
  * **Splash Screen:** Membuat `SplashScreen.kt` dengan jeda 3 detik menuju Home.
  * **Navigasi Dasar:** Membuat sealed class `Screen.kt` dan menyusun NavHost di `NavGraph.kt`. Memasang `NavGraph` ke dalam `MainActivity.kt`.
  * **Arsitektur MVI untuk Home:** Membuat `HomeState`, `HomeEvent`, dan `HomeViewModel` (dengan `@HiltViewModel`). Menyusun kerangka *layout* dasar di `HomeScreen.kt`.
* **Perbaikan Kompatibilitas Build Lanjutan:**
  * Menggunakan `android.disallowKotlinSourceSets=false` di `gradle.properties` agar KSP tidak bermasalah (error `Using kotlin.sourceSets DSL to add Kotlin sources is not allowed`) dengan kotlin bawaan AGP 9.0+.

### 2. Apa yang Perlu Dilakukan Selanjutnya (Handoff untuk Agen Berikutnya)
* **Perbaikan Build (compileSdk 37):** Saat ini agen sebelumnya meninggalkan build dalam keadaan **GAGAL** (`compileSdk` incompatibility). Dependensi `androidx.lifecycle` terbaru (2.11.0) membutuhkan API 37.
  * **TUGAS PERTAMA ANDA:** Buka `app/build.gradle.kts` dan ubah blok `compileSdk` dari `36` menjadi `37` (atau `release(37) { minorApiLevel = 1 }` menyesuaikan sintaks AGP 9). Setelah itu jalankan ulang `./gradlew assembleDebug`.
* **Pengujian Manual (Run App):** Setelah *build* sukses, pastikan aplikasi bisa berjalan (Splash screen tampil 3 detik, lalu masuk ke halaman "Dokumen Saya").
* **Selesaikan UI Home:** *HomeScreen* saat ini masih berupa kerangka dasar (hanya teks jumlah dokumen). Agen selanjutnya bisa mulai mendesain tampilan *list* dokumen.
* **Merge ke Sprint Branch:** Jika seluruh UI Foundation berjalan lancar, lakukan PR / *Merge* dari branch `feature/ui-foundation` ke `sprint/1-backend` atau `develop`, lalu pindah ke Milestone 2 (M2 - Kamera & Scanner).

### 3. Catatan Khusus untuk Developer / Agent Berikutnya
* **PENTING (Versi AGP & Plugin Kotlin):** Project ini menggunakan AGP versi sangat baru (`9.3.2`). **JANGAN** pernah menambahkan `id("org.jetbrains.kotlin.android")` secara eksplisit pada block `plugins {}` di `app/build.gradle.kts`.
* **Kompatibilitas Hilt (AGP 9):** Pastikan `android.newDsl=false` tetap ada di `gradle.properties` untuk menghindari *error* `Android BaseExtension not found`.
* **Kompatibilitas KSP (AGP 9):** Pastikan `android.disallowKotlinSourceSets=false` tetap ada di `gradle.properties` untuk menghindari *error* duplikasi pendaftaran *sourceSet* Kotlin oleh KSP.
* Terus perbarui catatan ini setiap kali Milestone atau sebuah pekerjaan krusial diselesaikan!
