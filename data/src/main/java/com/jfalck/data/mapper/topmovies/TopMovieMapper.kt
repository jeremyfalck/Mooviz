package com.jfalck.data.mapper.topmovies

import com.jfalck.data.dto.TopMovieDTO
import com.jfalck.domain.model.TopMovie

interface TopMovieMapper {
    fun mapToTopMovie(dto: TopMovieDTO): TopMovie
}