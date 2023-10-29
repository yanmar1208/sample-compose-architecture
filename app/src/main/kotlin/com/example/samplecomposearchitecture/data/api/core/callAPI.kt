package com.example.samplecomposearchitecture.data.api.core

import android.annotation.SuppressLint
import com.example.samplecomposearchitecture.domain.core.AppError
import java.io.IOException
import java.net.SocketTimeoutException
import retrofit2.HttpException

/**
 * アプリ内のAPI共通呼び出し処理
 *
 * APIを呼び出す予期にはこの関数を使用すること
 *
 * @param T APIのレスポンス
 * @param apiCall API呼び出し処理
 * @return APIのレスポンス
 */
@SuppressLint("class com.example.lint.AppCodeDetector")
suspend inline fun <T> callAPI(crossinline apiCall: suspend () -> T): T = try {
    apiCall.invoke()
} catch (throwable: Throwable) {
    when (throwable) {
        is IOException ->
            when (throwable) {
                is SocketTimeoutException -> throw AppError.Api.TimeoutException(throwable)
                else -> throw AppError.Api.NetworkException(throwable)
            }

        is HttpException -> throw AppError.Api.HttpException(
            message = throwable.message(),
            cause = throwable,
            code = throwable.code()
        )

        else -> throw AppError.UnknownException(throwable)
    }
}
