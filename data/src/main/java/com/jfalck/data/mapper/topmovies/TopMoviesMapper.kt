package com.jfalck.data.mapper.topmovies

import com.jfalck.data.dto.TopMoviesDTO
import com.jfalck.domain.model.TopMovies

interface TopMoviesMapper {
    fun mapToTopMovies(dto: TopMoviesDTO): TopMovies
}