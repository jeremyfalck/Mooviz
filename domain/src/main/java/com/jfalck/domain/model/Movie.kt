package com.jfalck.domain.model

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<MovieGenre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String, // ex: "en"
    val originalTitle: String,
    val overview: String, //Synopsis
    val popularity: Float,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String, // ex: "1999-10-12"
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String, // Slogan
    val title: String,
    val video: Boolean,
    val voteAverage: Float,
    val voteCount: Int
)

data class MovieGenre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCounty: String
)

data class ProductionCountry(
    val isoCode: String, // ex: "US"
    val name: String, // ex: "United States of America"
)

data class SpokenLanguage(
    val isoCode: String,
    val name: String
)