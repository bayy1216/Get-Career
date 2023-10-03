package com.reditus.getcareer.common.di

import com.reditus.getcareer.data.repository.career.CareerRepository
import com.reditus.getcareer.data.repository.career.CareerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideCareerRepository(
        careerRepositoryImpl: CareerRepositoryImpl
    ): CareerRepository
}