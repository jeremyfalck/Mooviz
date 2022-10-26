package com.jfalck.domain.usecases.favoritemovies

interface SetFavoriteMovieUseCase {
    suspend operator fun invoke(
        apiKey: String,
        language: String,
        movieId: Int,
        isFavorite: Boolean
    )
}