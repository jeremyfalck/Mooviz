package com.jfalck.domain.repository

import com.jfalck.domain.model.TopMovies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getTopMovies(apiKey: String, language: String, page: Int): Flow<TopMovies>
}