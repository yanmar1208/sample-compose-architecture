package com.example.samplecomposearchitecture.ui.core.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * Result<T>を返すsuspend処理を<LoadResult>に変換してflowとして返す
 *
 * @param block suspend処理
 */
inline fun <T> loadingFlow(
    crossinline block: suspend () -> T,
): Flow<LoadResult<T>> =
    flow {
        runCatching { block() }
            .fold(
                onSuccess = { LoadResult.Success(it) },
                onFailure = { LoadResult.Failure(it) },
            ).let { emit(it) }
    }.onStart { emit(LoadResult.Loading) }

/**
 * LoadResult<Result<T>>>をLoadResult<T>に変換する
 */
fun <T> Flow<LoadResult<Result<T>>>.unwrapResult(): Flow<LoadResult<T>> =
    map { loadResult ->
        when (loadResult) {
            is LoadResult.Success -> loadResult.value.fold(
                onSuccess = { LoadResult.Success(it) },
                onFailure = { LoadResult.Failure(it) },
            )

            is LoadResult.Failure -> LoadResult.Failure(loadResult.e)
            is LoadResult.Initial -> LoadResult.Initial
            is LoadResult.Loading -> LoadResult.Loading
        }
    }

/**
 * ロード状態を表すクラス
 */
sealed class LoadResult<out T> {

    /**
     * 初期状態
     */
    data object Initial : LoadResult<Nothing>()

    /**
     * ローディング状態
     */
    data object Loading : LoadResult<Nothing>()

    /**
     * 成功状態
     */
    data class Success<T>(val value: T) : LoadResult<T>()

    /**
     * 失敗状態
     */
    data class Failure(val e: Throwable) : LoadResult<Nothing>()
}

/**
 * 成功している場合はvalueを返し、それ以外はnullを返す
 */
val <T> LoadResult<T>.valueOrNull: T?
    get() = when (this) {
        is LoadResult.Success -> value
        else -> null
    }

/**
 * 失敗している場合はerrorを返し、それ以外はnullを返す
 */
val <T> LoadResult<T>.throwableOrNull: Throwable?
    get() = when (this) {
        is LoadResult.Failure -> e
        else -> null
    }
