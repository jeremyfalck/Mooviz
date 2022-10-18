package com.jfalck.data.repository

import com.jfalck.data.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.service.MoviesApiService
import com.jfalck.domain.model.TopMovies
import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val topMoviesMapper: TopMoviesMapper
) :
    MoviesRepository {
    override suspend fun getTopMovies(
        apiKey: String,
        language: String,
        page: Int
    ): TopMovies =
        topMoviesMapper.mapToTopMovies(
            moviesApiService.getTopMovies(apiKey, language, page)
        )
}