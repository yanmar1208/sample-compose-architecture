package com.example.samplecomposearchitecture.ui.screen.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplecomposearchitecture.ui.navigation.AppNavHost
import com.example.samplecomposearchitecture.ui.theme.SampleComposeArchitectureTheme

@Composable
fun AppScreen(viewModel: AppViewModel = hiltViewModel()) {
    SampleComposeArchitectureTheme {
        AppScreen()
    }
}

@Composable
private fun AppScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        AppNavHost()
    }
}
