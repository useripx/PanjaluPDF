package com.yogiario.panjalupdf.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DocumentEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PanjaluDatabase : RoomDatabase() {
    abstract val documentDao: DocumentDao
}
