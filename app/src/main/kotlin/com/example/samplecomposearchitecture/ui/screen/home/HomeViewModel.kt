package com.example.samplecomposearchitecture.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecomposearchitecture.domain.dog.model.Dog
import com.example.samplecomposearchitecture.domain.dog.usecase.DogUseCase
import com.example.samplecomposearchitecture.ui.core.result.LoadResult
import com.example.samplecomposearchitecture.ui.core.result.loadingFlow
import com.example.samplecomposearchitecture.ui.core.result.unwrapResult
import com.example.samplecomposearchitecture.ui.screen.home.model.HomeEvent
import com.example.samplecomposearchitecture.ui.screen.home.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dogUseCase: DogUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.initialState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val _event: MutableSharedFlow<HomeEvent> = MutableSharedFlow()
    val event: SharedFlow<HomeEvent> = _event.asSharedFlow()

    private val _dogResult: MutableStateFlow<LoadResult<Dog>> =
        MutableStateFlow(state.value.dogResult)

    init {
        _dogResult.onEach { dogResult ->
            _state.update { it.copy(dogResult = dogResult) }
        }.launchIn(viewModelScope)
    }

    /**
     * 画像をクリック
     */
    fun onImageClick(dog: Dog) = viewModelScope.launch {
        _event.emit(HomeEvent.ToDetail(dog = dog))
    }

    /**
     * Dogデータを取得
     */
    private fun fetchDog() {
        loadingFlow { dogUseCase() }
            .unwrapResult()
            .onEach { result ->
                _dogResult.update { result }
            }.launchIn(viewModelScope)
    }
}