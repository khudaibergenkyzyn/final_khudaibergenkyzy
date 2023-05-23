package com.example.data.apiservice

import com.example.domain.model.NewsResponse

interface ApiService {
    suspend fun getAllNews(): NewsResponse
}