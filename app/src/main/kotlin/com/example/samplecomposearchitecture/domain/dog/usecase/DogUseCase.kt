package com.example.samplecomposearchitecture.domain.dog.usecase

import com.example.samplecomposearchitecture.domain.dog.model.Dog
import com.example.samplecomposearchitecture.domain.dog.repository.DogRepository
import javax.inject.Inject

/**
 * DogのUseCase
 */
class DogUseCase @Inject constructor(
    private val dogRepository: DogRepository,
) {
    suspend operator fun invoke(): Result<Dog> = runCatching {
        dogRepository.getDog()
    }
}
