package com.example.samplecomposearchitecture.ui.screen.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecomposearchitecture.domain.dog.model.Dog
import com.example.samplecomposearchitecture.domain.dog.usecase.DogUseCase
import com.example.samplecomposearchitecture.ui.core.extension.saveableFlow
import com.example.samplecomposearchitecture.ui.core.result.LoadResult
import com.example.samplecomposearchitecture.ui.core.result.loadingFlow
import com.example.samplecomposearchitecture.ui.core.result.unwrapResult
import com.example.samplecomposearchitecture.ui.screen.detail.model.DetailEvent
import com.example.samplecomposearchitecture.ui.screen.detail.model.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val args: DetailArgs = DetailArgs(savedStateHandle)

    private val _state: MutableStateFlow<DetailState> =
        MutableStateFlow(DetailState.initialState(args))
    val state: StateFlow<DetailState> = _state.asStateFlow()

    private val _event: MutableSharedFlow<DetailEvent> = MutableSharedFlow()
    val event: SharedFlow<DetailEvent> = _event.asSharedFlow()

    private val _url: MutableStateFlow<String> by savedStateHandle.saveableFlow(state.value.url)

    init {
        _url.onEach { url ->
            _state.update { it.copy(url = url) }
        }.launchIn(viewModelScope)
    }
}
