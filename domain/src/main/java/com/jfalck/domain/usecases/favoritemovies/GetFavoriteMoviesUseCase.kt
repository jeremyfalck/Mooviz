package com.jfalck.domain.usecases.favoritemovies

import com.jfalck.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetFavoriteMoviesUseCase {

    suspend operator fun invoke(): Flow<List<Movie>>
}