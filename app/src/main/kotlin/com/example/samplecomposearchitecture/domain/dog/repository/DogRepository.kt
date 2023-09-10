package com.example.samplecomposearchitecture.domain.dog.repository

import com.example.samplecomposearchitecture.domain.dog.model.Dog

/**
 * Dogのデータを扱うRepository
 */
interface DogRepository {

    /**
     * [Dog]を取得
     */
    suspend fun getDog(): Dog
}
