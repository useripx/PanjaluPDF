package com.yogiario.panjalupdf.data.repository

import com.yogiario.panjalupdf.data.local.database.DocumentDao
import com.yogiario.panjalupdf.data.local.database.DocumentEntity
import com.yogiario.panjalupdf.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Singleton
class DocumentRepositoryImpl @Inject constructor(
    private val dao: DocumentDao
) : DocumentRepository {
    override fun getAllDocuments(): Flow<List<DocumentEntity>> = dao.getAllDocuments()
    override suspend fun getDocumentById(id: Int): DocumentEntity? = withContext(Dispatchers.IO) { dao.getDocumentById(id) }
    override fun searchDocuments(query: String): Flow<List<DocumentEntity>> = dao.searchDocuments(query)
    override suspend fun insertDocument(document: DocumentEntity): Long = withContext(Dispatchers.IO) { dao.insertDocument(document) }
    override suspend fun deleteDocument(document: DocumentEntity): Int = withContext(Dispatchers.IO) { dao.deleteDocument(document) }
}
