package com.yogiario.panjalupdf.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogiario.panjalupdf.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DocumentRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        onEvent(HomeEvent.LoadDocuments)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadDocuments -> {
                viewModelScope.launch {
                    repository.getAllDocuments()
                        .onStart { _state.value = _state.value.copy(isLoading = true) }
                        .catch { e ->
                            _state.value = _state.value.copy(
                                isLoading = false,
                                errorMessage = e.message
                            )
                        }
                        .collect { docs ->
                            _state.value = _state.value.copy(
                                isLoading = false,
                                documents = docs
                            )
                        }
                }
            }
            is HomeEvent.OnSearchQueryChanged -> {
                // TODO: Implement hybrid search in M5
            }
        }
    }
}
