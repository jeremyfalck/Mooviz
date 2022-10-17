package com.jfalck.mooviz.feature.topmovies.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalck.domain.constants.MovieConstants.BASE_POSTER_URL
import com.jfalck.domain.model.Movie
import com.jfalck.mooviz.databinding.TopMovieItemBinding

class TopMoviesPagerAdapter(private val context: Context) :
    ListAdapter<Movie, TopMoviesPagerAdapter.TopMovieViewHolder>(TopMoviesDiffCallback()) {

    inner class TopMovieViewHolder(val binding: TopMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.topMovieItemTitle.text = item.title
        Glide.with(context).load(BASE_POSTER_URL + item.posterPath)
            .into(holder.binding.topMoviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder =
        TopMovieViewHolder(
            TopMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
}