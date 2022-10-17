package com.jfalck.mooviz.feature.topmovies.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jfalck.domain.model.Movie

class TopMoviesDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem == newItem
}