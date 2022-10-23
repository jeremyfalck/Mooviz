package com.jfalck.data.repository

import com.jfalck.data.local.db.MoviesDatabase
import com.jfalck.data.local.mapper.FavoriteMovieMapper
import com.jfalck.data.remote.mapper.movie.MovieMapper
import com.jfalck.data.remote.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.remote.service.MoviesApiService
import com.jfalck.domain.model.Movie
import com.jfalck.domain.model.TopMovies
import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val moviesDatabase: MoviesDatabase,
    private val topMoviesMapper: TopMoviesMapper,
    private val movieMapper: MovieMapper,
    private val favoriteMovieMapper: FavoriteMovieMapper
) : MoviesRepository {
    override suspend fun getTopMovies(
        apiKey: String, language: String, page: Int
    ): TopMovies = topMoviesMapper.mapToTopMovies(
        moviesApiService.getTopMovies(apiKey, language, page)
    )

    override suspend fun getMovieById(apiKey: String, language: String, movieId: Int): Movie =
        movieMapper.mapToMovie(moviesApiService.getMovieFromId(movieId, apiKey, language))

    override suspend fun addFavoriteMovie(movie: Movie) {
        moviesDatabase.favoriteMovieDao().insertAll(favoriteMovieMapper.mapToFavoriteMovie(movie))
    }

    override suspend fun deleteFavoriteMovie(movieId: Int) {
        TODO("Not yet implemented")
    }
}