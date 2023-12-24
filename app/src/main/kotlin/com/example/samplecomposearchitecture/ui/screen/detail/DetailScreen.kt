package com.example.samplecomposearchitecture.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.samplecomposearchitecture.ui.navigation.LocalNavController
import com.example.samplecomposearchitecture.ui.screen.home.HomeViewModel
import com.example.samplecomposearchitecture.ui.screen.home.model.HomeEvent
import com.example.samplecomposearchitecture.ui.widget.EventFlowEffect

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavHostController = LocalNavController.current,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

}

@Composable
private fun HomeScreen() {
}
