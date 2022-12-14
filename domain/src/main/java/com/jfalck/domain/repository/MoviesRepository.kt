package com.jfalck.domain.repository

import com.jfalck.domain.model.Movie
import com.jfalck.domain.model.TopMovies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getTopMovies(apiKey: String, language: String, page: Int): TopMovies

    suspend fun getMovieById(apiKey: String, language: String, movieId: Int): Movie

    suspend fun addFavoriteMovie(movie: Movie)
    suspend fun deleteFavoriteMovie(movieId: Int)
    suspend fun getFavoriteMovie(movieId: Int): Movie?
    suspend fun getFavoriteMovies(): Flow<List<Movie>>
}