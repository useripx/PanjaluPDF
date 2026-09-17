# Implementation Plan — Backend (BE) PanjaluPDF

**Status: 🔒 FIX v1.3** — baseline v1.0 disepakati sebagai titik awal development. **Revisi v1.1:** menambahkan Bagian 12 (Referensi Folder Template UI untuk konteks Antigravity IDE). **Revisi v1.2:** menambahkan Bagian 13 (Git & GitHub Workflow — repo dan aturan branch develop). **Revisi v1.3:** memperluas Bagian 13 dengan branching per-sprint dan per-fitur/perbaikan (`sprint/...`, `feature/...`, `fix/...`), menegaskan merge `develop` → `main` dilakukan manual oleh Yogi, bukan otomatis oleh agent. Perubahan berikutnya akan dicatat sebagai revisi bertanggal, bukan menimpa versi ini secara diam-diam.

**Disusun sebagai:** PM brief untuk development Backend, siap dipakai sebagai konteks kerja di **Google Antigravity IDE** **Arsitektur:** MVVM + Clean Architecture ringan **Prinsip utama:** 100% on-device, tanpa permission `INTERNET`, patuh kebijakan Play Store meski tidak dipublikasikan

---

## 1. Arsitektur

```
┌─────────────────────────────────────────────┐
│                    UI Layer                  │
│         (Compose Screen + ViewModel)         │
└───────────────────┬───────────────────────────┘
                    │ observe StateFlow
┌───────────────────▼───────────────────────────┐
│                 UseCase Layer                 │
│  ClassifyDocumentUseCase, SearchDocumentUseCase, │
│  ScanDocumentUseCase, ConvertToPdfUseCase, dst   │
└───────────────────┬───────────────────────────┘
                    │
┌───────────────────▼───────────────────────────┐
│                Repository Layer               │
│   DocumentRepository, OntologyRepository       │
└──────────┬──────────────────────┬───────────────┘
          │                      │
┌─────────▼─────────┐   ┌────────▼─────────────┐
│   Room Database    │   │   File Storage /     │
│  (metadata dokumen) │   │   Ontology JSON asset │
└─────────────────────┘   └───────────────────────┘
```

**Kenapa dipecah begini (bukan MVVM polos):**

- **UseCase** mengisolasi logic bisnis inti — terutama **algoritma klasifikasi ontologi** jadi satu class kecil yang berdiri sendiri, gampang di-unit test, dan bisa jadi bukti konkret ke dosen bahwa algoritmanya bisa ditelusuri (explainable)
- **Repository** jadi satu pintu akses data — ViewModel tidak pernah langsung sentuh Room/File, memudahkan mocking saat testing
- Pola ini standar industri, sekaligus **memudahkan penulisan BAB III (metodologi)** karena setiap layer punya tanggung jawab yang jelas dan bisa digambar sebagai diagram arsitektur

---

## 2. Tech Stack & Library

|Kategori|Library|Fungsi|
|---|---|---|
|Bahasa & UI|Kotlin, Jetpack Compose|Seluruh logic & UI|
|Navigasi|Navigation Compose|Navigasi antar screen|
|Kamera|CameraX|Live preview + capture dokumen|
|Import galeri|Photo Picker (`androidx.activity`)|Pilih foto tanpa permission storage|
|Permission|Accompanist Permissions|Kelola izin kamera (Compose-friendly)|
|OCR|Google ML Kit Text Recognition|Ekstraksi teks on-device|
|Database|Room|Metadata dokumen lokal|
|Background task|WorkManager|OCR + klasifikasi di background thread|
|Dependency Injection|Hilt|Injeksi Repository/UseCase, testable|
|Parsing ontologi|Kotlinx Serialization|Baca ontologi format JSON|
|PDF|PdfBox-Android (Apache 2.0)|Generate, merge, ekstrak PDF|
|Image loading|Coil|Thumbnail dokumen|
|Splash screen|AndroidX Core SplashScreen|Splash 3-5 detik|
|Async|Kotlin Coroutines & Flow|Semua operasi asynchronous|
|Testing|JUnit, MockK, Turbine|Unit test akurasi klasifikasi (BAB IV)|

**Prinsip pemilihan library:** semua harus bisa berjalan **tanpa koneksi internet**, tidak mengirim data telemetri ke server pihak ketiga (tidak pakai Firebase Analytics/Crashlytics), dan berlisensi permisif (Apache 2.0/MIT) agar aman disebutkan di laporan skripsi.

---

## 3. Struktur Folder/Package

```
com.panjalu.pdf/
├── di/                          # Hilt Modules
│   ├── DatabaseModule.kt
│   ├── RepositoryModule.kt
│   └── OntologyModule.kt
├── data/
│   ├── local/
│   │   ├── database/            # Room: Entity, DAO, Database
│   │   │   ├── DocumentEntity.kt
│   │   │   ├── DocumentDao.kt
│   │   │   └── PanjaluDatabase.kt
│   │   └── ontology/            # JSON ontologi + parser
│   │       ├── OntologyClass.kt        # data class kelas dokumen
│   │       ├── OntologyLoader.kt       # baca file JSON dari assets
│   │       └── assets/ontology.json
│   └── repository/
│       ├── DocumentRepositoryImpl.kt
│       └── OntologyRepositoryImpl.kt
├── domain/
│   ├── model/                   # Model bisnis murni (bukan Entity Room)
│   │   ├── Document.kt
│   │   └── DocumentType.kt
│   ├── repository/               # Interface (abstraksi)
│   │   ├── DocumentRepository.kt
│   │   └── OntologyRepository.kt
│   └── usecase/
│       ├── ScanDocumentUseCase.kt
│       ├── ClassifyDocumentUseCase.kt      # ⭐ inti algoritma ontologi
│       ├── SearchDocumentUseCase.kt        # hybrid search
│       ├── ConvertImageToPdfUseCase.kt
│       ├── MergePdfUseCase.kt
│       └── ExtractPdfToImageUseCase.kt
├── ocr/
│   └── MlKitTextRecognizer.kt   # wrapper Google ML Kit
├── worker/
│   └── DocumentProcessingWorker.kt  # WorkManager: OCR + klasifikasi background
├── ui/
│   ├── splash/
│   ├── convert/
│   ├── editfoto/
│   ├── dokumensaya/
│   ├── settings/
│   └── theme/                   # Aeris Authority design token
└── PanjaluApplication.kt        # @HiltAndroidApp
```

---

## 4. Detail Modul Kunci

### 4.1 Ontology Engine (`ClassifyDocumentUseCase`)

**Input:** teks hasil OCR (String) **Output:** `ClassificationResult(documentType, matchScore, matchedKeywords)`

**Alur logic:**

1. Load `ontology.json` (via `OntologyLoader`, di-cache di memori setelah load pertama)
2. Untuk tiap kelas ontologi, hitung skor = (jumlah kata kunci cocok ÷ total kata kunci kelas)
3. Pilih kelas dengan skor tertinggi
4. Jika skor tertinggi < threshold (misal 30%), kembalikan `DocumentType.UMUM` (fallback)
5. Kembalikan hasil lengkap dengan daftar kata kunci yang match (untuk ditampilkan di layar Detail Dokumen — breakdown kata kunci yang sudah ada di mockup)

**Format `ontology.json` (referensi):**

```json
{
  "classes": [
    {
      "name": "KTP",
      "keywords": ["NIK", "PROVINSI", "KEWARGANEGARAAN", "BERLAKU HINGGA"],
      "properties": ["nik", "nama", "alamat", "tanggal_lahir"]
    },
    {
      "name": "Invoice",
      "keywords": ["INVOICE", "TOTAL", "SUBTOTAL", "PPN"],
      "properties": ["no_invoice", "tanggal", "total"]
    }
  ]
}
```

**Unit test yang perlu dibuat** (untuk BAB IV — pengujian akurasi):

- Test dengan teks OCR dummy per kelas dokumen → pastikan hasil klasifikasi sesuai ground truth
- Test kasus ambigu (teks yang punya kata kunci dari 2 kelas berbeda)
- Test kasus dokumen tidak dikenali → harus fallback ke "Dokumen Umum"

### 4.2 Hybrid Search (`SearchDocumentUseCase`)

- Query masuk → jalankan **dua pencarian paralel** ke Room: `WHERE fileName LIKE :query` DAN `WHERE documentType LIKE :query OR ocrText LIKE :query`
- Gabungkan hasil (union, hilangkan duplikat by document ID)
- Room mendukung ini lewat satu query DAO dengan `OR` di WHERE clause — tidak perlu dua query terpisah secara fisik, cukup satu SQL yang mengecek kedua kolom sekaligus

### 4.3 Background Processing (`DocumentProcessingWorker`)

- Dijalankan via WorkManager tiap kali ada dokumen baru dari scan/convert
- Urutan kerja: baca file gambar → OCR (ML Kit) → `ClassifyDocumentUseCase` → simpan hasil ke Room
- Karena WorkManager, proses ini **survive** meski app di-kill di tengah jalan (penting untuk dokumen besar/multi-halaman)

---

## 5. Kepatuhan Kebijakan Play Store (meski tidak dipublikasikan)

|Area|Implementasi|
|---|---|
|**Scoped Storage**|Simpan file di app-specific directory (`getExternalFilesDir()`), tidak minta akses storage penuh|
|**Permission minimal**|Hanya `CAMERA`. **Tidak ada `INTERNET`** sama sekali di Manifest — ini bukti teknis kuat untuk klaim offline|
|**Photo Picker**|Pakai untuk import galeri, menghindari permission `READ_MEDIA_IMAGES`|
|**Runtime permission**|Kamera diminta saat runtime (via Accompanist Permissions), bukan cuma di Manifest|
|**Data Safety**|Karena tidak ada permission internet/analytics, app otomatis "tidak mengumpulkan/membagikan data" — draft Data Safety form ini bagus dilampirkan di skripsi sebagai bukti kepatuhan|
|**No third-party tracking**|Tidak pakai Firebase Analytics/Crashlytics/Ads SDK apa pun|
|**Privacy Policy draft**|Tetap disiapkan sebagai lampiran skripsi meski tidak upload — memperkuat argumen "dirancang sesuai standar produksi nyata"|

---

## 6. Strategi Testing (untuk BAB IV Skripsi)

|Jenis Test|Target|Tool|
|---|---|---|
|Unit Test|`ClassifyDocumentUseCase` — akurasi klasifikasi per kelas dokumen|JUnit + MockK|
|Unit Test|`SearchDocumentUseCase` — hybrid search mengembalikan hasil yang benar|JUnit|
|Integration Test|Room DAO — query & insert metadata dokumen|AndroidX Test + in-memory Room|
|Manual/UAT Test|Alur end-to-end scan → klasifikasi → tampil di Dokumen Saya|Manual, didokumentasikan sebagai skenario pengujian|

**Metrik yang dilaporkan di BAB IV:** precision, recall, F1-score dari hasil klasifikasi terhadap dataset uji (kumpulan sampel dokumen dengan label ground truth yang Anda siapkan sendiri).

---

## 7. Roadmap Implementasi Backend (selaras dengan Sprint Frontend)

|Sprint|Fokus Backend|Branch|
|---|---|---|
|**Sprint 1 — Foundation**|Setup Hilt, Room schema, struktur package, `PanjaluApplication`|`sprint/1-foundation`|
|**Sprint 2 — Scan & Convert**|CameraX integration, `ScanDocumentUseCase`, `ConvertImageToPdfUseCase` (pakai PdfBox-Android)|`sprint/2-scan-convert`|
|**Sprint 3 — Convert lanjutan**|`MergePdfUseCase`, `ExtractPdfToImageUseCase`|`sprint/3-convert-lanjutan`|
|**Sprint 4 — OCR + Ontologi**|`MlKitTextRecognizer`, `OntologyLoader`, **`ClassifyDocumentUseCase`** (prioritas tertinggi — inti nilai skripsi), `DocumentProcessingWorker`|`sprint/4-ocr-ontologi`|
|**Sprint 5 — Dokumen Saya**|`SearchDocumentUseCase` (hybrid search), Room query optimasi|`sprint/5-dokumen-saya`|
|**Sprint 6 — Polish & Testing**|Unit test lengkap, hitung precision/recall/F1, dokumentasi hasil pengujian untuk BAB IV|`sprint/6-polish-testing`|

_(Detail aturan penamaan & alur merge branch ada di Bagian 13.5.)_

---

## 8. Prompt Konteks untuk Antigravity IDE

Saat memulai sesi di Antigravity, berikan konteks berikut ke agent supaya hasil kodenya konsisten:

> "Proyek Android Kotlin bernama PanjaluPDF, arsitektur MVVM + Clean Architecture (UseCase + Repository layer). Stack: Jetpack Compose, Hilt, Room, WorkManager, CameraX, Google ML Kit Text Recognition, PdfBox-Android, Coil, Kotlinx Serialization. Prinsip: 100% on-device, tidak boleh ada permission INTERNET atau dependency yang mengirim data ke server. Struktur package mengikuti domain/data/ui layer terpisah. Fitur klasifikasi dokumen memakai ontologi ringan berbasis JSON (rule-based keyword matching + scoring), bukan machine learning."

Prompt ini bisa ditempel di awal sesi Antigravity setiap kali mulai kerja modul baru, supaya agent tetap konsisten dengan arsitektur yang sudah direncanakan.

---

## 9. Open Questions

- [ ] Threshold minimum skor klasifikasi sebelum dianggap "Dokumen Umum" — berapa persen? (disarankan mulai dari 30-40%, disesuaikan setelah uji coba dataset)
- [ ] Apakah hasil OCR mentah (full text) disimpan di Room untuk keperluan full-text search tambahan, atau cukup simpan `documentType` + kata kunci yang match saja? (mempengaruhi ukuran database)
- [ ] Batas ukuran file/jumlah halaman PDF yang didukung — perlu ditentukan untuk uji performa

---

## 10. Progress Indicator (Loading vs Hang)

**Masalah yang diselesaikan:** proses OCR + klasifikasi butuh beberapa detik; tanpa indikator jelas, user bisa mengira aplikasi freeze/hang.

**Tidak perlu library tambahan** — cukup kombinasi WorkManager Progress API (`setProgressAsync()`, bagian dari `androidx.work` yang sudah ada di stack) + Compose `LinearProgressIndicator` bawaan.

**Pembagian tahap & bobot persentase:**

|Tahap|Bobot|Label ditampilkan|
|---|---|---|
|OCR membaca teks (ML Kit)|0–50%|"Membaca teks dokumen..."|
|Klasifikasi ontologi (keyword matching)|50–80%|"Mengenali jenis dokumen..."|
|Simpan ke database & generate PDF|80–100%|"Menyimpan dokumen..."|

**Implementasi:**

- `DocumentProcessingWorker` memanggil `setProgressAsync()` di tiap transisi tahap (mis. kirim `0.5f` saat OCR selesai)
- UI (Compose) observe `WorkInfo` sebagai `Flow`, tampilkan `LinearProgressIndicator(progress = ...)` + teks persentase + label tahap
- **Catatan realistis:** ML Kit tidak memberi progress granular internal, sehingga persentase yang ditampilkan adalah **estimasi berbasis tahapan**, bukan progress presisi mengikuti proses internal OCR — tetap jujur dan efektif secara UX, tapi perlu disadari batasannya saat dijelaskan ke penguji.

---

## 11. Strategi Kompresi PDF

**Masalah yang diselesaikan:** foto kamera modern beresolusi tinggi (bisa 3-5 MB/gambar); scan dokumen multi-halaman (misal 20 halaman buku) bisa menghasilkan PDF puluhan MB.

**Prinsip: kompresi otomatis diam-diam, bukan popup per halaman.** Popup tiap halaman akan sangat mengganggu untuk sesi scan panjang.

**Pendekatan 2 lapis:**

1. **Default otomatis berdasarkan setting** — level kompresi ("Tinggi/Sedang/Standar", sudah ada di mockup Settings, default "Sedang") berlaku otomatis untuk semua proses scan tanpa perlu konfirmasi berulang. User ubah sekali di Settings, berlaku seterusnya.
2. **Smart prompt satu kali di akhir batch** — hanya muncul jika ukuran hasil akhir melewati threshold tertentu (misal >15 MB), ditampilkan **sekali setelah seluruh batch selesai** (bukan per halaman):
    
    > _"Dokumen ini berukuran 45 MB (20 halaman). Kompres sekarang untuk menghemat ruang? [Kompres] [Biarkan]"_
    

**Implementasi teknis:**

- Kompresi dilakukan pada level **gambar sebelum digabung jadi PDF**, bukan pada file PDF final
- Alur: downscale resolusi gambar (maksimal ~2000px sisi terpanjang — cukup untuk dokumen teks) → `Bitmap.compress()` bawaan Android dengan quality parameter sesuai level (Tinggi ≈ 90%, Sedang ≈ 75%, Standar ≈ 60%) → baru digabung jadi PDF via PdfBox-Android
- **Tidak butuh library tambahan** — `Bitmap.compress()` sudah bagian dari Android SDK bawaan
- Estimasi hasil: foto 5MB → turun ke ~300-800KB per halaman tergantung level, tanpa penurunan kualitas signifikan untuk keperluan baca dokumen (bukan cetak foto)

---

## 12. Referensi Folder Template UI (untuk Konteks Antigravity IDE)

**Lokasi folder:** `C:\Users\yogia\AndroidStudioProjects\PanjaluPDF\template`

Agent Antigravity **tidak otomatis tahu** folder ini ada atau apa isinya — harus **dijelaskan eksplisit di prompt konteks** setiap kali memulai sesi development UI, supaya agent tidak menebak-nebak struktur layar dari nol.

### 12.1 Isi Folder & Fungsinya

|File|Tipe|Fungsi|
|---|---|---|
|`DESIGN.md`|Markdown|Design system Aeris Authority (warna, tipografi, shape) — sumber kebenaran token desain, sudah dirangkum di Bagian 2 dokumen ini|
|`logo.png`|Gambar|Aset logo eagle-mark PanjaluPDF — dipakai untuk app icon & splash|
|`splashscreen.html` + `.png`|Referensi visual|Mockup Splash Screen|
|`convert.html` + `.png`|Referensi visual|Mockup tab Convert|
|`kamera_live_scan.html` + `.png`|Referensi visual|Mockup layar kamera/live preview saat scan|
|`edit_foto.html` + `.png`|Referensi visual|Mockup tab Edit Foto|
|`dokumen_saya.html` + `.png`|Referensi visual|Mockup tab Dokumen Saya|
|`detail_viewer_dokumen.html` + `.png`|Referensi visual|Mockup layar Detail Dokumen (breakdown skor & kata kunci)|
|`setting.html` + `.png`|Referensi visual|Mockup tab Settings|

**Penting — cara agent memperlakukan file ini:** file `.html` adalah **mockup statis** (hasil render visual dengan data contoh hardcoded), **bukan kode produksi**. Agent harus membacanya sebagai **referensi tata letak, hierarki komponen, dan styling saja** — lalu diimplementasikan ulang sebagai Composable Jetpack Compose yang terhubung ke ViewModel/state sungguhan, **bukan** disalin mentah sebagai WebView atau HTML string. File `.png` berguna untuk agent yang bisa membaca gambar, sebagai pengecekan visual cepat tanpa perlu parsing HTML.

### 12.2 Pemetaan Bagian Statis vs Dinamis per Layar

Ini yang paling penting dijelaskan ke agent — mockup HTML isinya **data contoh tetap (hardcoded)**, sedangkan implementasi aslinya harus terhubung ke sumber data nyata (Room DB, hasil OCR, dll).

**`splashscreen`**

- Statis: logo, wordmark, tagline "SHARP • PRECISION • INTELLIGENT", label versi
- Dinamis: progress loading (kalau load ontologi/cek permission jalan di background), nomor versi app (ambil dari `BuildConfig.VERSION_NAME`, jangan hardcode)

**`convert`**

- Statis: teks deskripsi tiap card (Image to PDF, Merge PDF, PDF to Image), ikon, badge "Paling Populer"/"Multi-Hal"
- Dinamis: **tidak banyak** — tab ini sebagian besar navigational (tap card → buka flow lain). Yang dinamis hanya kalau nanti ditambah statistik (misal "X dokumen sudah dikonversi")

**`kamera_live_scan`**

- Statis: label instruksi ("Posisikan dokumen di dalam bingkai"), tombol AUTO/grid
- Dinamis: **feed kamera real-time** (CameraX preview), **overlay bounding box deteksi tepi** (koordinat 4 titik sudut dihitung real-time dari algoritma edge detection, bukan posisi tetap), indikator sudut kemiringan (derajat)

**`edit_foto`**

- Statis: label tools (Crop & Sudut, Putar 90°, Filter), preset (Magic Color, Hitam Putih, Asli, Grayscale)
- Dinamis: **gambar hasil scan aktual** (bukan gambar contoh), **posisi 4 titik crop draggable** (bergantung hasil deteksi tepi, user bisa geser manual), nilai slider Kecerahan & Kontras (state yang berubah sesuai interaksi user, disimpan sementara sebelum "Simpan Dokumen"), label "Deteksi Sudut Otomatis: XX%" (nilai confidence real dari algoritma, bukan angka tetap 99.4% seperti di mockup)

**`dokumen_saya`**

- Statis: placeholder search bar, label kolom
- Dinamis: **seluruh list dokumen** (dari query Room, bukan 4 item contoh di mockup), **badge jenis dokumen & skor kecocokan** (hasil `ClassifyDocumentUseCase`), **jumlah per filter chip** ("Semua (12)", "KTP (2)", dst — dihitung dari COUNT query, bukan angka tetap), hasil pencarian (berubah real-time sesuai query hybrid search)

**`detail_viewer_dokumen`**

- Statis: label field ("Metode", "Kata Kunci Terverifikasi", dst)
- Dinamis: **gambar dokumen aktual**, seluruh data breakdown klasifikasi (jenis dokumen terdeteksi, skor kecocokan, daftar kata kunci yang match beserta skor masing-masing, bobot kumulatif) — **semua ini harus berasal dari objek `ClassificationResult` sungguhan** yang disimpan saat dokumen diproses, bukan angka contoh yang di-hardcode di mockup (di mockup ada "98%", "NIK 100%", dst — itu semua harus jadi variabel nyata)

**`setting`**

- Statis: label section, deskripsi tiap opsi
- Dinamis: **state tiap toggle** (Dark Mode, Deteksi Tepi Otomatis, Klasifikasi Ontologi, Suara Shutter — disimpan di DataStore Preferences, bukan Room), path folder penyimpanan aktual, nomor versi app

### 12.3 Prompt Tambahan untuk Antigravity IDE

Tambahkan ke prompt konteks (melengkapi prompt di Bagian 8) setiap kali mengerjakan modul UI:

> "Referensi visual mockup tersedia di folder `C:\Users\yogia\AndroidStudioProjects\PanjaluPDF\template` — berisi file `.html` (mockup statis dengan data contoh hardcoded) dan `.png` (screenshot) untuk tiap layar: splashscreen, convert, kamera_live_scan, edit_foto, dokumen_saya, detail_viewer_dokumen, setting. Juga ada `DESIGN.md` (design token) dan `logo.png` (aset logo). Gunakan file-file ini HANYA sebagai referensi layout, hierarki komponen, dan styling — JANGAN disalin sebagai HTML/WebView. Implementasikan ulang sebagai Composable Jetpack Compose yang state-nya terhubung ke ViewModel sungguhan. Semua data contoh yang terlihat di mockup (nama dokumen, skor kecocokan, jumlah per kategori, dll) adalah data dummy untuk ilustrasi — di implementasi asli harus diganti dengan data dinamis dari Room Database/UseCase sesuai spesifikasi di dokumen Implementation Plan Backend & Frontend."

---

## 13. Git & GitHub Workflow

**Repository:** `https://github.com/useripx/PanjaluPDF.git`

Agent Antigravity juga perlu diberi tahu eksplisit soal repo ini dan aturan branch-nya di prompt konteks — supaya setiap perubahan (fitur baru, perbaikan bug, revisi mockup, dll) yang dikerjakan agent otomatis diarahkan ke tempat yang benar, bukan sekadar tersimpan lokal.

### 13.1 Aturan Branch

|Branch|Fungsi|Aturan|
|---|---|---|
|`main`|Versi stabil/rilis|**Tidak pernah** menerima commit atau merge dari agent secara otomatis. Merge dari `develop` ke `main` **dilakukan manual oleh Yogi saja**, di luar sesi kerja Antigravity — biasanya menjelang checkpoint penting (sebelum demo/sidang)|
|`develop`|Branch integrasi utama|Semua branch sprint dan branch fitur/perbaikan **bermuara ke sini** lewat merge. Ini branch kerja "resmi" proyek selama development berjalan|
|`sprint/<nomor>-<nama>`|Kerja per sprint|Dibuat dari `develop` di awal tiap sprint (lihat tabel Bagian 7). Berisi seluruh pekerjaan sprint tsb, merge kembali ke `develop` setelah sprint dianggap selesai/stabil|
|`feature/<nama-fitur>`|Kerja per fitur spesifik dalam satu sprint|Contoh: `feature/edge-detection`, `feature/ontology-matcher`, `feature/hybrid-search`. Dibuat dari branch sprint yang sedang aktif, merge kembali ke branch sprint tsb setelah selesai|
|`fix/<nama-perbaikan>`|Perbaikan bug/revisi kecil|Contoh: `fix/badge-semantik-ke-rulebased`, `fix/watermark-overlap`. Dibuat dari `develop` (kalau perbaikan lintas-sprint/setelah sprint selesai) atau dari branch sprint aktif (kalau bug ditemukan saat sprint masih berjalan)|

**Alur bertingkat:** `feature/...` atau `fix/...` → merge ke `sprint/...` → merge ke `develop` → (manual, terpisah) merge ke `main`

### 13.2 Alur Kerja Standar

1. Clone repo: `git clone https://github.com/useripx/PanjaluPDF.git`
2. Pastikan branch `develop` ada dan jadi basis kerja: `git checkout develop` (atau `git checkout -b develop` kalau belum ada di remote)
3. **Di awal tiap sprint**, buat branch sprint baru dari `develop`: `git checkout -b sprint/4-ocr-ontologi develop`
4. **Untuk tiap fitur/perbaikan dalam sprint itu**, buat branch turunan dari branch sprint: `git checkout -b feature/ontology-matcher sprint/4-ocr-ontologi`
5. Commit dengan pesan jelas: `git commit -m "feat: implementasi ClassifyDocumentUseCase"`
6. Setelah fitur selesai & diuji, merge kembali ke branch sprint: `git checkout sprint/4-ocr-ontologi && git merge feature/ontology-matcher`
7. Setelah semua fitur dalam sprint selesai, merge branch sprint ke `develop`: `git checkout develop && git merge sprint/4-ocr-ontologi`
8. Push `develop` ke remote: `git push origin develop`
9. **Merge `develop` → `main` dilakukan manual oleh Yogi**, kapan pun dianggap perlu — agent tidak melakukan ini secara otomatis

### 13.3 Konvensi Commit Message (disarankan)

Supaya riwayat commit rapi dan gampang ditelusuri saat menulis BAB III/IV (bisa jadi bukti progres pengembangan yang terdokumentasi):

- `feat: ...` — penambahan fitur baru
- `fix: ...` — perbaikan bug
- `refactor: ...` — perubahan struktur kode tanpa mengubah fungsi
- `docs: ...` — perubahan dokumentasi (termasuk update Implementation Plan)
- `test: ...` — penambahan/perbaikan unit test

### 13.4 Prompt Tambahan untuk Antigravity IDE

Tambahkan ke prompt konteks di awal sesi:

> "Repository proyek ada di `https://github.com/useripx/PanjaluPDF.git`. Struktur branch: `main` (stabil, JANGAN PERNAH di-push/merge oleh agent — murni manual oleh Yogi), `develop` (branch integrasi utama), `sprint/<nomor>-<nama>` (dibuat dari develop di awal tiap sprint, sesuai Bagian 7), `feature/<nama>` atau `fix/<nama>` (dibuat dari branch sprint aktif untuk tiap pekerjaan spesifik). Alur merge: feature/fix → sprint → develop. Gunakan konvensi commit message: `feat:`, `fix:`, `refactor:`, `docs:`, `test:` sesuai jenis perubahan. Selalu buat branch baru yang deskriptif untuk tiap pekerjaan, jangan commit langsung ke `develop` tanpa branch turunan kecuali perubahan sangat kecil (misal typo dokumentasi)."

### 13.5 Referensi Silang

Nama branch sprint (`sprint/1-foundation` s/d `sprint/6-polish-testing`) mengikuti urutan di **Bagian 7 — Roadmap Implementasi Backend**. Branch `feature/`/`fix/` dibuat sesuai kebutuhan modul yang sedang dikerjakan (lihat daftar UseCase di Bagian 4 untuk penamaan yang konsisten, misal `feature/classify-document-usecase`).

---

_Dokumen ini saling melengkapi dengan `Implementation_Plan_Frontend_PanjaluPDF.md` — gunakan keduanya sebagai konteks utuh saat development di Antigravity IDE._