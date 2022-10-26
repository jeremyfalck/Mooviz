package com.jfalck.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.jfalck.data.local.db.converters.GenreConverter
import com.jfalck.data.local.db.converters.ProducionCompanyConverter
import com.jfalck.data.local.db.converters.ProductionCountryConverter
import com.jfalck.data.local.db.converters.SpokenLanguageConverter

@Entity(
    tableName = "favorite_movie",
)
data class FavoriteMovie(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "adult")
    val adult: Boolean?,
    @ColumnInfo(name = "backdropPath")
    val backdropPath: String?,
    @ColumnInfo(name = "budget")
    val budget: Int?,
    @ColumnInfo(name = "genres")
    @TypeConverters(GenreConverter::class)
    val genres: List<Genre>,
    @ColumnInfo(name = "homepage")
    val homepage: String?,
    @ColumnInfo(name = "imdb_id")
    val imdbId: String?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?, // ex: "en"
    @ColumnInfo(name = "original_title")
    val originalTitle: String?,
    @ColumnInfo(name = "overview")
    val overview: String?, //Synopsis
    @ColumnInfo(name = "popularity")
    val popularity: Float?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "production_companies")
    @TypeConverters(ProducionCompanyConverter::class)
    val productionCompanies: List<ProductionCompany>,
    @ColumnInfo(name = "production_countries")
    @TypeConverters(ProductionCountryConverter::class)
    val productionCountries: List<ProductionCountry>,
    @ColumnInfo(name = "release_date")
    val releaseDate: String?, // ex: "1999-10-12"
    @ColumnInfo(name = "revenue")
    val revenue: Int?,
    @ColumnInfo(name = "runtime")
    val runtime: Int?,
    @ColumnInfo(name = "spoken_languages")
    @TypeConverters(SpokenLanguageConverter::class)
    val spokenLanguages: List<SpokenLanguage>,
    @ColumnInfo(name = "status")
    val status: String?,
    @ColumnInfo(name = "tagline")
    val tagline: String?, // Slogan
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "video")
    val video: Boolean,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Float?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int?
)

data class Genre(
    val id: Int?,
    val name: String?
)

data class ProductionCompany(
    val id: Int?,
    val logoPath: String?,
    val name: String?,
    val originCountry: String?
)

data class ProductionCountry(
    val isoCode: String?, // ex: "US"
    val name: String?, // ex: "United States of America"
)

data class SpokenLanguage(
    val isoCode: String?,
    val name: String?
)