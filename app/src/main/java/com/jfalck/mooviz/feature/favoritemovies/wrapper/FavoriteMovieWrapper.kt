package com.jfalck.mooviz.feature.favoritemovies.wrapper

import com.jfalck.domain.model.Movie

class FavoriteMovieWrapper(private val movie: Movie) {
    fun getId() = movie.id ?: 0

    fun getTitle() = movie.title ?: ""

    fun getPosterPath() = movie.posterPath ?: ""

    override fun equals(other: Any?): Boolean {
        return if (other is FavoriteMovieWrapper) {
            other.getId() == getId() && other.getTitle() == getTitle() && other.getPosterPath() == getPosterPath()
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return movie.hashCode()
    }
}