package com.example.samplecomposearchitecture.data.repository

import com.example.samplecomposearchitecture.data.api.api.DogAPI
import com.example.samplecomposearchitecture.data.model.toDomainModel
import com.example.samplecomposearchitecture.domain.dog.model.Dog
import com.example.samplecomposearchitecture.domain.dog.repository.DogRepository
import javax.inject.Inject

class DogRepositoryImpl
@Inject
constructor(
    private val dogAPI: DogAPI
) : DogRepository {
    override suspend fun getDog(): Dog = dogAPI.getDog().toDomainModel()
}
