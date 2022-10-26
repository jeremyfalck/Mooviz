package com.jfalck.domain.usecases.favoritemovies

import android.util.Log
import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject

class SetFavoriteMovieUseCaseImpl @Inject constructor(
    private val moviesRepository: MoviesRepository,
) : SetFavoriteMovieUseCase {
    override suspend fun invoke(
        apiKey: String,
        language: String,
        movieId: Int,
        isFavorite: Boolean
    ) {
        if (isFavorite) {
            try {
                val movie = moviesRepository.getMovieById(apiKey, language, movieId)
                if (moviesRepository.getFavoriteMovie(movieId) == null) {
                    moviesRepository.addFavoriteMovie(movie)
                }
            } catch (e: Exception) {
                Log.e("SetFavoriteMovie", e.message ?: "Error")
            }
        } else {
            moviesRepository.deleteFavoriteMovie(movieId)
        }
    }
}