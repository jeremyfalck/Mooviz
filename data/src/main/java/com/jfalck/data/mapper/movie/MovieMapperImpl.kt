package com.jfalck.data.mapper.movie

import com.jfalck.data.dto.MovieDTO
import com.jfalck.domain.model.Movie

class MovieMapperImpl : MovieMapper {
    override fun mapToMovie(dto: MovieDTO): Movie = Movie(
        id = dto.id,
        title = dto.title,
        overview = dto.overview,
        posterPath = dto.posterPath,
        backdropPath = dto.backdropPath,
        releaseDate = dto.releaseDate,
        voteAverage = dto.voteAverage,
        voteCount = dto.voteCount,
        popularity = dto.popularity,
        originalLanguage = dto.originalLanguage,
        originalTitle = dto.originalTitle,
        genreIds = dto.genreIds,
        video = dto.video,
        adult = dto.adult
    )
}