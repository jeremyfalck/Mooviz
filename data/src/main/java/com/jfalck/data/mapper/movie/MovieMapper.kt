package com.jfalck.data.mapper.movie

import com.jfalck.data.dto.MovieDTO
import com.jfalck.domain.model.Movie

interface MovieMapper {
    fun mapToMovie(dto: MovieDTO): Movie
}