# Berikut Saran yang harus ada di update selanjutnya dari Google Play Console

**Layar penuh mungkin tidak ditampilkan untuk semua pengguna**

Mulai
 Android 15, semua aplikasi yang menargetkan SDK 35 akan menampilkan
tata letak layar penuh secara default. Aplikasi yang menargetkan SDK 35
harus menangani inset untuk memastikan aplikasi ditampilkan dengan benar
 di Android 15 dan yang lebih baru. Selidiki masalah ini dan luangkan
waktu untuk menguji aplikasi secara menyeluruh dan melakukan update yang
 diperlukan. Atau, panggil **enableEdgeToEdge()** untuk Kotlin atau **EdgeToEdge.enable()** untuk Java untuk kompatibilitas mundur.
atau baca
`https://developer.android.com/about/versions/15/behavior-changes-15?hl=id#edge-to-edge`

**Hapus batasan orientasi dan perubahan ukuran di aplikasi Anda untuk mendukung perangkat layar besar**

Mulai Android 16, Android akan mengabaikan pembatasan orientasi dan perubahan ukuran untuk perangkat layar besar, seperti perangkat foldable dan tablet. Hal ini dapat menyebabkan masalah tata letak dan kegunaan bagi pengguna Anda.

Kami mendeteksi batasan orientasi dan perubahan ukuran berikut di aplikasi Anda:

```kotlin
<activity android:name="com.google.mlkit.vision.documentscanner.internal.GmsDocumentScanningDelegateActivity" android:screenOrientation="PORTRAIT" />
```

Untuk meningkatkan pengalaman pengguna untuk aplikasi Anda, hapus pembatasan ini dan pastikan tata letak aplikasi Anda berfungsi pada berbagai ukuran dan orientasi layar dengan mengujinya di Android 16 dan yang lebih rendah.
