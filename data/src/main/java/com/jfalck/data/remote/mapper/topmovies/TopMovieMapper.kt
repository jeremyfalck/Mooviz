package com.jfalck.data.remote.mapper.topmovies

import com.jfalck.data.remote.dto.TopMovieDTO
import com.jfalck.domain.model.TopMovie

interface TopMovieMapper {
    fun mapToTopMovie(dto: TopMovieDTO): TopMovie
}