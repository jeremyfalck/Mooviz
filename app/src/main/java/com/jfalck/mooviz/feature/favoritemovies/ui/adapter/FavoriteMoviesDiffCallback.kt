package com.jfalck.mooviz.feature.favoritemovies.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jfalck.mooviz.feature.favoritemovies.wrapper.FavoriteMovieWrapper

class FavoriteMoviesDiffCallback : DiffUtil.ItemCallback<FavoriteMovieWrapper>() {
    override fun areItemsTheSame(
        oldItem: FavoriteMovieWrapper,
        newItem: FavoriteMovieWrapper
    ): Boolean =
        oldItem.getId() == newItem.getId()

    override fun areContentsTheSame(
        oldItem: FavoriteMovieWrapper,
        newItem: FavoriteMovieWrapper
    ): Boolean =
        oldItem == newItem
}