package com.yogiario.panjalupdf.ui.home

sealed class HomeEvent {
    object LoadDocuments : HomeEvent()
    data class OnSearchQueryChanged(val query: String) : HomeEvent()
}
