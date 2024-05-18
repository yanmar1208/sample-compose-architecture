package com.example.samplecomposearchitecture.ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

/**
 * ViewModelのイベントを受け取るためのComposable
 *
 * ComposeでFlowを受け取って非同期でcollectし、collectorの中身を実行する
 */
@Composable
fun <T> EventFlowEffect(flow: Flow<T>, collector: FlowCollector<T>) {
    LaunchedEffect(key1 = flow) {
        flow.collect {
            // それぞれのイベントを並列処理したいのでlaunchしている
            // launchしない場合、あるイベントでsuspend処理すると、そのイベントが終了するまでその後のイベントが処理されなくなる
            launch { collector.emit(it) }
        }
    }
}
