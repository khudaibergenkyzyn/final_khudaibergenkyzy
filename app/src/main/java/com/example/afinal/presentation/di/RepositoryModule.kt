package com.example.afinal.presentation.di

import com.example.data.apiservice.ApiService
import com.example.data.repository.NewsRepositoryImpl
import com.example.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(apiService: ApiService): NewsRepository {
        return NewsRepositoryImpl(apiService)
    }
}