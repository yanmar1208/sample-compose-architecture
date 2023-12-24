package com.example.samplecomposearchitecture.ui.screen.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.samplecomposearchitecture.ui.navigation.AppNavHost
import com.example.samplecomposearchitecture.ui.navigation.LocalNavController
import com.example.samplecomposearchitecture.ui.theme.SampleComposeArchitectureTheme

@Composable
fun AppScreen(viewModel: AppViewModel = hiltViewModel()) {
    SampleComposeArchitectureTheme {
        AppCompositionLocalProvider {
            AppScreen()
        }
    }
}

@Composable
private fun AppScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavHost()
    }
}

/**
 * アプリ内のCompositionLocalをprovideする
 *
 * @param navController [NavHostController]
 * @param content ラップするComposable
 */
@Composable
private fun AppCompositionLocalProvider(
    navController: NavHostController = rememberNavController(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        content()
    }
}
