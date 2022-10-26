package com.jfalck.domain.usecases.favoritemovies

import com.jfalck.domain.model.Movie
import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCaseImpl @Inject constructor(
    private val moviesRepository: MoviesRepository,
) : GetFavoriteMoviesUseCase {
    override suspend fun invoke(): Flow<List<Movie>> =
        moviesRepository.getFavoriteMovies()
}