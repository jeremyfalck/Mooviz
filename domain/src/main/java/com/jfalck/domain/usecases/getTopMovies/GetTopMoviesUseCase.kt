package com.jfalck.domain.usecases.getTopMovies

import com.jfalck.domain.model.TopMovies
import kotlinx.coroutines.flow.Flow

interface GetTopMoviesUseCase {
    suspend operator fun invoke(apiKey: String, language: String, page: Int): Flow<TopMovies>
}