package com.example.samplecomposearchitecture.ui.screen.detail.model

/**
 * 詳細画面のイベント
 */
sealed class DetailEvent {
    /**
     * 前の画面に戻る
     */
    data object Back : DetailEvent()
}
