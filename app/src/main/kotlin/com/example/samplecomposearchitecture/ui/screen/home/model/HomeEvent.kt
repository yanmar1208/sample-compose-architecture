package com.example.samplecomposearchitecture.ui.screen.home.model

import com.example.samplecomposearchitecture.domain.dog.model.Dog

/**
 * ホームのイベント
 */
sealed class HomeEvent {
    /**
     * 詳細画面へ
     */
    data class ToDetail(
        val dog: Dog,
    ) : HomeEvent()
}
