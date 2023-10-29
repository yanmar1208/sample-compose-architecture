package com.example.samplecomposearchitecture.domain.core

import kotlin.RuntimeException

sealed class AppError : RuntimeException {
    constructor(message: String?) : super(message)
    constructor(cause: Throwable?) : super(cause)

    /**
     * APIに関するエラー
     */
    sealed class Api : AppError {
        constructor(message: String?) : super(message)
        constructor(cause: Throwable?) : super(cause)

        /**
         * ネットワークエラー
         */
        data class NetworkException(
            override val cause: Throwable?
        ) : Api(cause)

        /**
         * Httpエラー
         */
        data class HttpException(
            override val message: String,
            override val cause: Throwable?,
            val code: Int
        ) : Api(cause)

        /**
         * タイムアウトエラー
         */
        data class TimeoutException(
            override val cause: Throwable?
        ) : Api(cause)
    }

    /**
     * 不明なエラー
     */
    class UnknownException : AppError {
        constructor(message: String?) : super(message)
        constructor(cause: Throwable?) : super(cause)
    }
}
