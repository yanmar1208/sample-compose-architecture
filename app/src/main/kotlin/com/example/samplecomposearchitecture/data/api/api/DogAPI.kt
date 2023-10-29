package com.example.samplecomposearchitecture.data.api.api

import com.example.samplecomposearchitecture.data.model.DogData
import retrofit2.http.GET

/**
 * Dog API
 */
interface DogAPI {
    /**
     * ランダムな画像URL取得
     */
    @GET("image/random")
    suspend fun getDog(): DogData
}
