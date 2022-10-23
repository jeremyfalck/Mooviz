package com.jfalck.domain.model

data class TopMovies(
    val page: Int,
    val results: List<TopMovie>,
    val totalPages: Int,
    val totalResults: Int
)
