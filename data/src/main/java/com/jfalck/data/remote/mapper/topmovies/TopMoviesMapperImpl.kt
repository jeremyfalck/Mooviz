package com.jfalck.data.remote.mapper.topmovies

import com.jfalck.data.remote.dto.TopMoviesDTO
import com.jfalck.domain.model.TopMovies
import javax.inject.Inject

class TopMoviesMapperImpl @Inject constructor(private val topMovieMapper: TopMovieMapper) :
    TopMoviesMapper {
    override fun mapToTopMovies(dto: TopMoviesDTO, favoriteMoviesIds: List<Int>): TopMovies {
        return TopMovies(
            page = dto.page,
            results = dto.results.map { topMovieMapper.mapToTopMovie(it, favoriteMoviesIds) },
            totalPages = dto.totalPages,
            totalResults = dto.totalResults
        )
    }
}