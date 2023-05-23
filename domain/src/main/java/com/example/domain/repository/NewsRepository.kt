package com.example.domain.repository

import com.example.domain.model.NewsResponse

interface NewsRepository {
    suspend fun getAllNews(): NewsResponse
}