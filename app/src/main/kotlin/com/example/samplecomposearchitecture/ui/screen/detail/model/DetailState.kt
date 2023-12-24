package com.example.samplecomposearchitecture.ui.screen.detail.model

import com.example.samplecomposearchitecture.domain.dog.model.Dog
import com.example.samplecomposearchitecture.ui.core.result.LoadResult
import com.example.samplecomposearchitecture.ui.screen.detail.DetailArgs

/**
 * 詳細画面のState
 *
 * @property url 画像URL
 */
data class DetailState(
    val url: String
) {
    companion object {
        /**
         * 初期化
         *
         * @param detailArgs 詳細画面の引数
         */
        fun initialState(
            detailArgs: DetailArgs,
        ): DetailState = DetailState(
            url = detailArgs.url,
        )
    }
}
