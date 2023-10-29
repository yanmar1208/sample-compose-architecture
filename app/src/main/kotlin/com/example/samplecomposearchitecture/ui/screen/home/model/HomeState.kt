package com.example.samplecomposearchitecture.ui.screen.home.model

import com.example.samplecomposearchitecture.domain.dog.model.Dog
import com.example.samplecomposearchitecture.ui.core.result.LoadResult

/**
 * ホーム画面のState
 *
 * @property dogResult Dogデータの読み込み状態
 */
data class HomeState(
    val dogResult: LoadResult<Dog>
) {
    companion object {
        /**
         * 初期化
         */
        fun initialState(): HomeState = HomeState(
            dogResult = LoadResult.Initial
        )
    }
}
