package com.jfalck.data.local.mapper

import com.jfalck.data.local.db.entity.FavoriteMovie
import com.jfalck.data.local.db.entity.Genre
import com.jfalck.domain.model.Movie
import com.jfalck.domain.model.MovieGenre

class FavoriteMovieMapperImpl : FavoriteMovieMapper {

    override fun mapToFavoriteMovie(movie: Movie): FavoriteMovie =
        FavoriteMovie(
            id = movie.id ?: 0,
            adult = movie.adult,
            backdropPath = movie.backdropPath,
            budget = movie.budget,
            genres = movie.genres.map { Genre(it.id, it.name) },
            homepage = movie.homepage,
            imdbId = movie.imdbId,
            originalLanguage = movie.originalLanguage,
            originalTitle = movie.originalTitle,
            overview = movie.overview,
            popularity = movie.popularity,
            posterPath = movie.posterPath,
            productionCompanies = movie.productionCompanies.map {
                com.jfalck.data.local.db.entity.ProductionCompany(
                    it.id,
                    it.logoPath,
                    it.name,
                    it.originCountry
                )
            },
            productionCountries = movie.productionCountries.map {
                com.jfalck.data.local.db.entity.ProductionCountry(
                    it.isoCode,
                    it.name
                )
            },
            releaseDate = movie.releaseDate,
            revenue = movie.revenue,
            runtime = movie.runtime,
            spokenLanguages = movie.spokenLanguages.map {
                com.jfalck.data.local.db.entity.SpokenLanguage(
                    it.isoCode,
                    it.name
                )
            },
            status = movie.status,
            tagline = movie.tagline,
            title = movie.title,
            video = movie.video,
            voteAverage = movie.voteAverage,
            voteCount = movie.voteCount
        )

    override fun mapFavoriteMovieToMovie(favoriteMovie: FavoriteMovie): Movie =
        Movie(
            adult = favoriteMovie.adult ?: false,
            backdropPath = favoriteMovie.backdropPath,
            budget = favoriteMovie.budget,
            genres = favoriteMovie.genres.map { MovieGenre(it.id, it.name) },
            homepage = favoriteMovie.homepage,
            id = favoriteMovie.id,
            imdbId = favoriteMovie.imdbId,
            originalLanguage = favoriteMovie.originalLanguage,
            originalTitle = favoriteMovie.originalTitle,
            overview = favoriteMovie.overview,
            popularity = favoriteMovie.popularity,
            posterPath = favoriteMovie.posterPath,
            productionCompanies = favoriteMovie.productionCompanies.map {
                com.jfalck.domain.model.ProductionCompany(
                    it.id,
                    it.logoPath,
                    it.name,
                    it.originCountry
                )
            },
            productionCountries = favoriteMovie.productionCountries.map {
                com.jfalck.domain.model.ProductionCountry(
                    it.isoCode,
                    it.name
                )
            },
            releaseDate = favoriteMovie.releaseDate,
            revenue = favoriteMovie.revenue,
            runtime = favoriteMovie.runtime,
            spokenLanguages = favoriteMovie.spokenLanguages.map {
                com.jfalck.domain.model.SpokenLanguage(
                    it.isoCode,
                    it.name
                )
            },
            status = favoriteMovie.status,
            tagline = favoriteMovie.tagline,
            title = favoriteMovie.title,
            video = favoriteMovie.video,
            voteAverage = favoriteMovie.voteAverage,
            voteCount = favoriteMovie.voteCount
        )
}