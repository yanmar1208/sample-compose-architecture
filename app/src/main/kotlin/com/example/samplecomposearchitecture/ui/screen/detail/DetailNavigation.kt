package com.example.samplecomposearchitecture.ui.screen.detail

import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.samplecomposearchitecture.ui.core.extension.navigateSafely

/**
 * [DetailScreen]のナビゲーション構造
 */
fun NavGraphBuilder.detail() {
    composable(DETAIL_ROUTE) {
        DetailScreen()
    }
}

/**
 * [DetailScreen]に遷移
 */
fun NavHostController.navigateToDetail(url: String) {
    navigateSafely(
        to = DETAIL_ROUTE,
        args = bundleOf(
            DetailArgKeys.Url.name to url
        )
    )
}

/**
 * 詳細画面の遷移時引数
 *
 * @property url URL
 */
data class DetailArgs(
    val url: String
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        url = requireNotNull(savedStateHandle[DetailArgKeys.Url.name])
    )
}

const val DETAIL_ROUTE = "detail"

enum class DetailArgKeys {
    Url
}
