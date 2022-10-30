package com.jfalck.mooviz.feature.moviedetail.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jfalck.mooviz.databinding.GenreItemBinding

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.GenreViewHolder>() {

    var genres = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class GenreViewHolder(val binding: GenreItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
        GenreViewHolder(
            GenreItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.binding.root.text = genres[position]
    }

    override fun getItemCount(): Int =
        genres.size
}