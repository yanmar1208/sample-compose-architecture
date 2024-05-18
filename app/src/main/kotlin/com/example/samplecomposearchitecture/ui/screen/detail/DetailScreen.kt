package com.example.samplecomposearchitecture.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.samplecomposearchitecture.ui.navigation.LocalNavController
import com.example.samplecomposearchitecture.ui.screen.detail.model.DetailEvent
import com.example.samplecomposearchitecture.ui.screen.detail.model.DetailState
import com.example.samplecomposearchitecture.ui.widget.EventFlowEffect

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavHostController = LocalNavController.current
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    EventFlowEffect(flow = viewModel.event) { event ->
        when (event) {
            DetailEvent.Back -> navController.navigateUp()
        }
    }

    DetailScreen(uiState = uiState)
}

@Composable
private fun DetailScreen(uiState: DetailState) {
}
