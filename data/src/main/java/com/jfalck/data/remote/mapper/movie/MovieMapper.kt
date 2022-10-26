package com.jfalck.data.remote.mapper.movie

import com.jfalck.data.remote.dto.MovieDTO
import com.jfalck.domain.model.Movie

interface MovieMapper {

    fun mapToMovie(dto: MovieDTO): Movie

}