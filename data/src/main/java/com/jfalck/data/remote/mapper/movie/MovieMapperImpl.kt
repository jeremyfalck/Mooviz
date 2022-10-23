package com.jfalck.data.remote.mapper.movie

import com.jfalck.data.remote.dto.MovieDTO
import com.jfalck.domain.model.Movie
import com.jfalck.domain.model.MovieGenre
import com.jfalck.domain.model.ProductionCompany
import com.jfalck.domain.model.ProductionCountry
import com.jfalck.domain.model.SpokenLanguage

class MovieMapperImpl : MovieMapper {
    override fun mapToMovie(dto: MovieDTO): Movie = Movie(
        adult = dto.adult,
        backdropPath = dto.backdropPath ?: "",
        budget = dto.budget,
        genres = dto.genres.map { MovieGenre(it.id, it.name ?: "") },
        homepage = dto.homepage ?: "",
        id = dto.id,
        imdbId = dto.imdbId ?: "",
        originalLanguage = dto.originalLanguage,
        originalTitle = dto.originalTitle,
        overview = dto.overview ?: "",
        popularity = dto.popularity,
        posterPath = dto.posterPath ?: "",
        productionCompanies = dto.productionCompanies.map {
            ProductionCompany(
                it.id,
                it.logoPath ?: "",
                it.name ?: "",
                it.originCounty ?: ""
            )
        },
        productionCountries = dto.productionCountries.map {
            ProductionCountry(
                it.isoCode,
                it.name ?: ""
            )
        },
        releaseDate = dto.releaseDate,
        revenue = dto.revenue,
        runtime = dto.runtime ?: 0,
        spokenLanguages = dto.spokenLanguages.map { SpokenLanguage(it.isoCode, it.name ?: "") },
        status = dto.status,
        tagline = dto.tagline ?: "",
        title = dto.title,
        video = dto.video,
        voteAverage = dto.voteAverage,
        voteCount = dto.voteCount
    )
}