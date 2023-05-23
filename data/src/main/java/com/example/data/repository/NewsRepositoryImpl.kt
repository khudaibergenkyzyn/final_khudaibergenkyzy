package com.example.data.repository

import com.example.data.apiservice.ApiService
import com.example.domain.model.NewsResponse
import com.example.domain.repository.NewsRepository

class NewsRepositoryImpl (private val apiService: ApiService): NewsRepository {

    override suspend fun getAllNews(): NewsResponse {
        return apiService.getAllNews()
    }

}