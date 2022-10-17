package com.jfalck.mooviz.feature.topmovies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jfalck.domain.model.Movie
import com.jfalck.mooviz.databinding.TopMovieItemBinding

class TopMoviesPagerAdapter :
    RecyclerView.Adapter<TopMoviesPagerAdapter.TopMovieViewHolder>() {

    inner class TopMovieViewHolder(val binding: TopMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var list = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
        holder.binding.topMovieItemTitle.text = list[position].title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder =
        TopMovieViewHolder(
            TopMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
}