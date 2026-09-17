package com.yogiario.panjalupdf.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yogiario.panjalupdf.domain.model.DocumentType

@Entity(tableName = "documents")
data class DocumentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fileName: String,
    val filePath: String,
    val documentType: DocumentType,
    val ocrText: String,
    val matchScore: Float,
    val matchedKeywords: List<String>,
    val createdAt: Long
)
