package com.jfalck.domain.usecases.moviedetail

import com.jfalck.domain.model.Movie

interface GetMovieDetailUseCase {
    suspend operator fun invoke(apiKey: String, language: String, movieId: Int): Movie
}