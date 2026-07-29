# Panduan Mengganti Nama Proyek Android Studio

**Dari: VelaPDF**
**Menjadi: Panjalu PDF**

Dokumen ini berisi langkah-langkah lengkap untuk mengganti nama proyek, nama aplikasi, *package name*, hingga nama folder utama (root) di Android Studio. Ikuti langkah-langkah ini secara berurutan.

## 1. Mengubah Nama Aplikasi (App Name)

Ini adalah nama yang akan muncul di *homescreen* HP pengguna dan di Play Store.

1. Buka file `app/src/main/res/values/strings.xml`.
2. Cari baris: `<string name="app_name">VelaPDF</string>`.
3. Ubah menjadi: `<string name="app_name">Panjalu PDF</string>`.

## 2. Mengubah Application ID dan Namespace di Gradle

Ini adalah identitas unik aplikasi Anda di sistem Android.

1. Buka file `app/build.gradle.kts`.
2. Cari bagian `namespace` dan `applicationId`.
3. Ubah kodenya menjadi seperti ini:
   ```kotlin
   android {
       namespace = "com.njagakneai.panjalupdf"
       // ...
       defaultConfig {
           applicationId = "com.njagakneai.panjalupdf"
           // ...
       }
   }
   ```
4. Klik tombol **Sync Now** yang muncul di bar bagian atas editor.

## 3. Melakukan Refactor Nama Package (Direktori Kode)

Langkah ini sangat penting untuk menyesuaikan struktur folder *source code* Anda.

1. Di jendela **Project** sebelah kiri, pastikan Anda berada di mode tampilan **Android**.
2. Klik ikon gir (Settings/Gear ⚙️) di pojok kanan atas jendela Project.
3. Cari opsi **Compact Middle Packages** (atau *Compact Empty Middle Packages*) dan pastikan **TIDAK DICENTANG**. Tujuannya agar folder `com`, `njagakneai`, dan `velapdf` bisa diklik satu per satu secara terpisah.
4. Buka urutan folder: `app` > `java` > `com` > `njagakneai` > lalu **klik kanan pada folder `velapdf`**.
5. Pilih **Refactor** > **Rename...** (atau tekan `Shift + F6` di keyboard).
6. Jika muncul *pop-up* peringatan, pastikan Anda memilih opsi **Rename Package** (bukan *Rename Directory*).
7. Ketikkan nama *package* baru: `panjalupdf`.
8. Klik tombol **Refactor**.
9. Perhatikan bagian bawah layar (jendela *Find*). Akan muncul daftar file yang terdampak perubahan. Klik tombol **Do Refactor** untuk menyetujui semua perubahannya.

## 4. Mengubah Nama Proyek Internal di Gradle

1. Buka file `settings.gradle.kts` (letaknya biasanya di bagian *Gradle Scripts*).
2. Cari baris kodenya yang bertuliskan: `rootProject.name = "VelaPDF"`
3. Ubah menjadi: `rootProject.name = "Panjalu PDF"`
4. Klik **Sync Now** lagi.

## 5. Mengubah Nama Folder Utama (Root Folder) - *Langkah Manual*

Ini adalah langkah krusial yang **hanya bisa dilakukan secara manual oleh Anda** melalui Windows File Explorer, karena folder sedang digunakan/dikunci oleh Android Studio.

1. Di Android Studio, klik menu **File** (pojok kiri atas) > pilih **Close Project**. (Android Studio akan kembali ke menu awal / *Welcome Screen*).
2. Buka **File Explorer** bawaan Windows dan navigasi ke direktori ini: `C:\Users\yogia\AndroidStudioProjects\`.
3. Cari folder bernama `VelaPDF`.
4. Klik kanan folder tersebut, pilih ikon **Rename** (atau tekan F2), dan ubah namanya menjadi `PanjaluPDF` (tanpa spasi lebih disarankan untuk folder root).
5. Kembali ke *Welcome Screen* Android Studio, klik tombol **Open**.
6. Arahkan ke folder `PanjaluPDF` yang baru saja Anda *rename* dan klik **OK**.

## 6. Membersihkan dan Membangun Ulang (Clean & Rebuild)

Langkah terakhir untuk memastikan tidak ada sisa-sisa *cache* dari nama proyek yang lama.

1. Di menu atas Android Studio, klik menu **Build** > lalu pilih **Clean Project**. Tunggu sampai proses selesai di bagian bawah.
2. Setelah selesai, klik **Build** > lalu pilih **Rebuild Project**.

## 7. Memperbarui Firebase dan google-services.json (PENTING!)

Karena proyek ini menggunakan Firebase (misal untuk Google Sign-In), mengubah *package name* akan membuat aplikasi kehilangan akses ke Firebase.
Kunci **SHA-1 Anda TIDAK BERUBAH** secara otomatis karena SHA-1 terikat pada laptop/keystore Anda, bukan pada nama proyek. Namun, Firebase belum mengenali *package name* yang baru.

Berikut cara mengatasinya:

1. Buka [Firebase Console](https://console.firebase.google.com/) di browser Anda.
2. Buka proyek Firebase yang Anda gunakan untuk aplikasi ini.
3. Tambahkan aplikasi Android baru (**Add App** > **Android**).
4. Masukkan **Package Name yang baru**: `com.njagakneai.panjalupdf`.
5. Masukkan **SHA-1** lama Anda (sama persis dengan yang Anda daftarkan sebelumnya untuk VelaPDF).
6. **Download** file `google-services.json` yang baru.
7. Masukkan/timpa file `google-services.json` yang ada di dalam folder `app/` di Android Studio Anda dengan file yang baru ini.
8. (Opsional) Anda bisa menghapus aplikasi lama `com.njagakneai.velapdf` dari pengaturan Firebase agar rapi.

---

Selesai! Sekarang proyek Anda sepenuhnya telah berganti nama menjadi **Panjalu PDF** dan terhubung kembali dengan Firebase dengan sempurna.
