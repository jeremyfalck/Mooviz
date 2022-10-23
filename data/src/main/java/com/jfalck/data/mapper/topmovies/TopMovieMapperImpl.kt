package com.jfalck.data.mapper.topmovies

import com.jfalck.data.dto.TopMovieDTO
import com.jfalck.domain.model.TopMovie

class TopMovieMapperImpl : TopMovieMapper {
    override fun mapToTopMovie(dto: TopMovieDTO): TopMovie = TopMovie(
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