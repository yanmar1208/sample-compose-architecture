package com.example.samplecomposearchitecture.ui.screen.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.samplecomposearchitecture.ui.core.extension.navigateSafely

/**
 * [HomeScreen]のナビゲーション構造
 */
fun NavGraphBuilder.home() {
    composable(HOME_ROUTE) {
        HomeScreen()
    }
}

/**
 * [HomeScreen]に遷移
 */
fun NavHostController.navigateToHome() {
    navigateSafely(to = HOME_ROUTE)
}

const val HOME_ROUTE = "home"
