package com.jfalck.domain.usecases.favoritemovies

interface SetFavoriteMovieUseCase {

    operator fun invoke(movieId: Int, isFavorite: Boolean)
}