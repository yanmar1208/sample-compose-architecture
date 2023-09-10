package com.example.samplecomposearchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.samplecomposearchitecture.ui.screen.home.HOME_ROUTE
import com.example.samplecomposearchitecture.ui.screen.home.home

/**
 * [NavHostController]をprovideする
 */
val LocalNavController = compositionLocalOf<NavHostController> {
    error("not NavHostController provided")
}

/**
 * NavHost
 */
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = LocalNavController.current,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HOME_ROUTE,
    ) {
        home()
    }
}