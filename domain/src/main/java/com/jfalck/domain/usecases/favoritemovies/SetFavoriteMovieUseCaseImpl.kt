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
            val movie = moviesRepository.getMovieById(apiKey, language, movieId)
            Log.d("SetFavoriteMovieUseCase", movie.toString())
        } else {
            // TODO get movie from db and delete it if not favorite
        }
    }
}