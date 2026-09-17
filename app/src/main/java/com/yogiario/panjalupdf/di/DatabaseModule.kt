package com.yogiario.panjalupdf.di

import android.app.Application
import androidx.room.Room
import com.yogiario.panjalupdf.data.local.database.DocumentDao
import com.yogiario.panjalupdf.data.local.database.PanjaluDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePanjaluDatabase(app: Application): PanjaluDatabase {
        return Room.databaseBuilder(
            app,
            PanjaluDatabase::class.java,
            "panjalu_pdf_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDocumentDao(db: PanjaluDatabase): DocumentDao {
        return db.documentDao
    }
}
