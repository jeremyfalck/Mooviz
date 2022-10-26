package com.jfalck.domain.usecases.favoritemovies

import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject

class RemoveFavoriteMovieUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    RemoveFavoriteMovieUseCase {
    override suspend fun invoke(movieId: Int) =
        moviesRepository.deleteFavoriteMovie(movieId)
}