package com.yogiario.panjalupdf.data.local.database

import androidx.room.TypeConverter
import com.yogiario.panjalupdf.domain.model.DocumentType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun fromDocumentType(value: DocumentType): String {
        return value.name
    }

    @TypeConverter
    fun toDocumentType(value: String): DocumentType {
        return try {
            DocumentType.valueOf(value)
        } catch (e: IllegalArgumentException) {
            DocumentType.UMUM
        }
    }

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return try {
            Json.decodeFromString(value)
        } catch (e: Exception) {
            emptyList()
        }
    }
}
