package com.jfalck.domain.repository

import com.jfalck.domain.model.Movie
import com.jfalck.domain.model.TopMovies

interface MoviesRepository {
    suspend fun getTopMovies(apiKey: String, language: String, page: Int): TopMovies

    suspend fun getMovieById(apiKey: String, language: String, movieId: Int): Movie

    suspend fun addFavoriteMovie(movie: Movie)

    suspend fun deleteFavoriteMovie(movieId: Int)
}