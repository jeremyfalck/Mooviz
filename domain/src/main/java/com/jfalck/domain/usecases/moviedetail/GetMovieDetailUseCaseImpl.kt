package com.jfalck.domain.usecases.moviedetail

import com.jfalck.domain.model.Movie
import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMovieDetailUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMovieDetailUseCase {
    override suspend fun invoke(apiKey: String, language: String, movieId: Int): Movie =
        // Retrieving movie data from database if movie is stored, otherwise from API
        moviesRepository.getFavoriteMovie(movieId) ?: moviesRepository.getMovieById(
            apiKey,
            language,
            movieId
        )
}