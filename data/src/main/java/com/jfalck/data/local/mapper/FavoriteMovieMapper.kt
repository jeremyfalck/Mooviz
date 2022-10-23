package com.jfalck.data.local.mapper

import com.jfalck.data.local.db.entity.FavoriteMovie
import com.jfalck.domain.model.Movie


interface FavoriteMovieMapper {

    fun mapToFavoriteMovie(movie: Movie): FavoriteMovie

    fun mapFavoriteMovieToMovie(favoriteMovie: FavoriteMovie): Movie

}