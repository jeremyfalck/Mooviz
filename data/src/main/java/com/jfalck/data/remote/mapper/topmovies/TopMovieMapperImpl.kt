package com.jfalck.data.remote.mapper.topmovies

import com.jfalck.data.remote.dto.TopMovieDTO
import com.jfalck.domain.model.TopMovie

class TopMovieMapperImpl : TopMovieMapper {
    override fun mapToTopMovie(dto: TopMovieDTO, favoriteMoviesIds: List<Int>): TopMovie = TopMovie(
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
        adult = dto.adult,
        isFavorite = favoriteMoviesIds.any { it == dto.id }
    )
}