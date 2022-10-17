package com.jfalck.domain.model

data class TopMovies(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
