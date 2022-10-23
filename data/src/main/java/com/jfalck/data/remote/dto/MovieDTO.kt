package com.jfalck.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdropPath") val backdropPath: String?,
    @SerializedName("budget") val budget: Int,
    @SerializedName("genres") val genres: List<GenreDTO>,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("original_language") val originalLanguage: String, // ex: "en"
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String?, //Synopsis
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyDTO>,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountryDTO>,
    @SerializedName("release_date") val releaseDate: String, // ex: "1999-10-12"
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguageDTO>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String?, // Slogan
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int
)

data class GenreDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?
)

data class ProductionCompanyDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("origin_county") val originCounty: String?
)

data class ProductionCountryDTO(
    @SerializedName("iso_3166_1") val isoCode: String, // ex: "US"
    @SerializedName("name") val name: String?, // ex: "United States of America"
)

data class SpokenLanguageDTO(
    @SerializedName("iso_639_1") val isoCode: String,
    @SerializedName("name") val name: String?
)
