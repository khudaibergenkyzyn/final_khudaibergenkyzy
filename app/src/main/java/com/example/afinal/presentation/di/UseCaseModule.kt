package com.example.afinal.presentation.di

import com.example.domain.repository.NewsRepository
import com.example.domain.usecase.GetNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesUseCase(newsRepository: NewsRepository):GetNews{
        return GetNews((newsRepository))
    }
}