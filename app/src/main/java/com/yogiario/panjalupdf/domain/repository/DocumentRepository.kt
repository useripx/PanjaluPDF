package com.yogiario.panjalupdf.domain.repository

import com.yogiario.panjalupdf.data.local.database.DocumentEntity
import kotlinx.coroutines.flow.Flow

interface DocumentRepository {
    fun getAllDocuments(): Flow<List<DocumentEntity>>
    suspend fun getDocumentById(id: Int): DocumentEntity?
    fun searchDocuments(query: String): Flow<List<DocumentEntity>>
    suspend fun insertDocument(document: DocumentEntity): Long
    suspend fun deleteDocument(document: DocumentEntity): Int
}
