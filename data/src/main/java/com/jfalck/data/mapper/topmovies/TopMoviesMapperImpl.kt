package com.jfalck.data.mapper.topmovies

import com.jfalck.data.dto.TopMoviesDTO
import com.jfalck.domain.model.TopMovies
import javax.inject.Inject

class TopMoviesMapperImpl @Inject constructor(private val topMovieMapper: TopMovieMapper) :
    TopMoviesMapper {
    override fun mapToTopMovies(dto: TopMoviesDTO): TopMovies {
        return TopMovies(
            page = dto.page,
            results = dto.results.map { topMovieMapper.mapToTopMovie(it) },
            totalPages = dto.totalPages,
            totalResults = dto.totalResults
        )
    }
}