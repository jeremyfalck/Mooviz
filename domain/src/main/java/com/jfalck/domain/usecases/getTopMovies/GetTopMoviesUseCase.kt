package com.jfalck.domain.usecases.getTopMovies

import androidx.paging.PagingData
import com.jfalck.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopMoviesUseCase {
    suspend operator fun invoke(
        apiKey: String,
        language: String,
        page: Int
    ): Flow<PagingData<Movie>>
}