package com.jfalck.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TopMoviesDTO(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<TopMovieDTO>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)