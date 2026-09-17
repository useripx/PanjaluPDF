package com.yogiario.panjalupdf.ui.home

import com.yogiario.panjalupdf.data.local.database.DocumentEntity

data class HomeState(
    val isLoading: Boolean = false,
    val documents: List<DocumentEntity> = emptyList(),
    val errorMessage: String? = null
)
