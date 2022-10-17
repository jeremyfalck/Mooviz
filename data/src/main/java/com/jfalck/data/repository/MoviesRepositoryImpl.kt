package com.jfalck.data.repository

import com.jfalck.data.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.service.MoviesApiService
import com.jfalck.domain.model.TopMovies
import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val topMoviesMapper: TopMoviesMapper
) :
    MoviesRepository {
    override suspend fun getTopMovies(
        apiKey: String,
        language: String,
        page: Int
    ): Flow<TopMovies> =
        flow {
            emit(moviesApiService.getTopMovies(apiKey, language, page))
        }.map { response ->
            topMoviesMapper.mapToTopMovies(response)
        }
}