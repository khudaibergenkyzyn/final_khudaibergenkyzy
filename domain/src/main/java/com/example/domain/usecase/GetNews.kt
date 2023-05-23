package com.example.domain.usecase

import com.example.domain.repository.NewsRepository

class GetNews (private val newsRepository: NewsRepository) {
    suspend operator fun invoke() = newsRepository.getAllNews()
}