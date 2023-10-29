package com.example.samplecomposearchitecture.data.repository

import com.example.samplecomposearchitecture.domain.dog.repository.DogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideDogRepository(dogRepositoryImpl: DogRepositoryImpl): DogRepository
}
