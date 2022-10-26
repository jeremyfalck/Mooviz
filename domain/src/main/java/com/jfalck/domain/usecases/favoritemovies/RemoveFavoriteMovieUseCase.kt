package com.jfalck.domain.usecases.favoritemovies

interface RemoveFavoriteMovieUseCase {

    suspend operator fun invoke(movieId: Int)
}