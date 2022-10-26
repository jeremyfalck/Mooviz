package com.jfalck.mooviz.feature.topmovies.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jfalck.domain.model.TopMovie

class TopMoviesDiffCallback : DiffUtil.ItemCallback<TopMovie>() {
    override fun areItemsTheSame(oldItem: TopMovie, newItem: TopMovie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TopMovie, newItem: TopMovie): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: TopMovie, newItem: TopMovie): Any? {
        if (oldItem.isFavorite != newItem.isFavorite) {
            return IS_FAVORITE_KEY
        }
        return ""
    }
}