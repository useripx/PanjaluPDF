package com.njagakneai.panjalupdf.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njagakneai.panjalupdf.domain.ontology.CourseGrade
import com.njagakneai.panjalupdf.domain.ontology.KhsDocument
import com.njagakneai.panjalupdf.domain.parser.UnpKediriKhsParser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewKhsScreen(
    onNavigateBack: () -> Unit
) {
    // Dummy Data: Simulasi hasil OCR mentah dari KHS Universitas Nusantara PGRI Kediri
    val dummyOcrText = """
        Nama : Yogi Ario Pratama
        NPM : 2313020004
        Prodi : S1-Teknik Informatika
        Semester : GANJIL
        Thn Akademik : 2025/2026
        
        1 TIF1019 Desain dan Animasi 3 A 12
        2 TIF1020 Jaringan Komputer II 4 A 16
        3 TIF1021 Mobile Application 3 B+ 9.9
        4 TIF1022 Pemrograman Web II 4 A- 14.8
        5 TIF1023 Machine Learning 4 C+ 9.2
        
        Total SKS : 18
        Indeks Prestasi : 3,44
    """.trimIndent()

    // Parsing dummy data menggunakan Parser yang telah dibuat
    val parser = remember { UnpKediriKhsParser() }
    val khsDocument = remember { parser.parse(dummyOcrText) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Preview Hasil KHS", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Total SKS: ${khsDocument.totalSks}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Indeks Prestasi (IP): ${khsDocument.gpa}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Button(
                        onClick = { /* TODO: Export to Excel/CSV */ },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Ekspor Excel")
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                // Header (Informasi Mahasiswa)
                StudentInfoCard(khsDocument)
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = "Detail Mata Kuliah",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                // Table Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("No", modifier = Modifier.weight(0.1f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text("Mata Kuliah", modifier = Modifier.weight(0.4f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text("SKS", modifier = Modifier.weight(0.15f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text("Nilai", modifier = Modifier.weight(0.15f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text("Mutu", modifier = Modifier.weight(0.2f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }
            
            items(khsDocument.courses) { course ->
                CourseTableRow(course)
                HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
            }
        }
    }
}

@Composable
fun StudentInfoCard(khs: KhsDocument) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Nama:", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Text(text = khs.studentName, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "NPM:", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Text(text = khs.npm, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Prodi:", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Text(text = khs.studyProgram, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Semester:", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Text(text = "${khs.semester} - ${khs.academicYear}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun CourseTableRow(course: CourseGrade) {
    // Validasi nilai mutu dari parser
    // Kita asumsikan getGradeWeight(course.gradeLetter) adalah bobot sebenarnya. 
    // Tapi karena fungsi itu private di parser, kita lakukan pengecekan sederhana: 
    // Jika course.gradeWeight != OCR membaca (sudah dikoreksi di parser), kita bisa beri tanda.
    // Di sini kita tunjukkan UI nya saja.
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(course.no.toString(), modifier = Modifier.weight(0.1f), fontSize = 12.sp)
        Column(modifier = Modifier.weight(0.4f)) {
            Text(course.name, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            Text(course.code, fontSize = 10.sp, color = Color.Gray)
        }
        Text(course.credit.toString(), modifier = Modifier.weight(0.15f), fontSize = 12.sp)
        Text(course.gradeLetter, modifier = Modifier.weight(0.15f), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        
        Row(modifier = Modifier.weight(0.2f), verticalAlignment = Alignment.CenterVertically) {
            Text(course.gradeWeight.toString(), fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            // Misalnya jika ada anomali bisa dimunculkan icon warning (opsional)
        }
    }
}
