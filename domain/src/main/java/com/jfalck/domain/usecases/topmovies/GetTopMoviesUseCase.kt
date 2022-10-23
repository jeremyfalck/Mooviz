package com.jfalck.domain.usecases.topmovies

import androidx.paging.PagingData
import com.jfalck.domain.model.TopMovie
import kotlinx.coroutines.flow.Flow

interface GetTopMoviesUseCase {
    suspend operator fun invoke(
        apiKey: String,
        language: String,
        page: Int
    ): Flow<PagingData<TopMovie>>
}