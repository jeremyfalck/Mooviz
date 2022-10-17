package com.jfalck.data.mapper.topmovies

import com.jfalck.data.dto.TopMoviesDTO
import com.jfalck.data.mapper.movie.MovieMapper
import com.jfalck.domain.model.TopMovies
import javax.inject.Inject

class TopMoviesMapperImpl @Inject constructor(private val movieMapper: MovieMapper) :
    TopMoviesMapper {
    override fun mapToTopMovies(dto: TopMoviesDTO): TopMovies {
        return TopMovies(
            page = dto.page,
            results = dto.results.map { movieMapper.mapToMovie(it) },
            totalPages = dto.totalPages,
            totalResults = dto.totalResults
        )
    }
}