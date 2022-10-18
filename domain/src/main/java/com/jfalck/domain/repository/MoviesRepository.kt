package com.jfalck.domain.repository

import com.jfalck.domain.model.TopMovies

interface MoviesRepository {
    suspend fun getTopMovies(apiKey: String, language: String, page: Int): TopMovies
}