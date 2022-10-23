package com.jfalck.data.remote.mapper.topmovies

import com.jfalck.data.remote.dto.TopMoviesDTO
import com.jfalck.domain.model.TopMovies

interface TopMoviesMapper {
    fun mapToTopMovies(dto: TopMoviesDTO): TopMovies
}