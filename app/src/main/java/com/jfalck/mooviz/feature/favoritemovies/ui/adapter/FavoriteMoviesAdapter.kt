package com.jfalck.mooviz.feature.favoritemovies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalck.domain.constants.MovieConstants.BASE_POSTER_URL
import com.jfalck.domain.model.Movie
import com.jfalck.mooviz.databinding.FavoriteMovieItemBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class FavoriteMoviesAdapter @Inject constructor() :
    ListAdapter<Movie, FavoriteMoviesAdapter.FavoriteMoviesViewHolder>(FavoriteMoviesDiffCallback()) {


    var onUnFavorite: (Int) -> Unit = { }

    inner class FavoriteMoviesViewHolder(val binding: FavoriteMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder =
        FavoriteMoviesViewHolder(
            FavoriteMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        getItem(position).let { movie ->
            holder.binding.run {
                favoriteMovieItemTitle.text = movie.title
                Glide.with(root.context).load(BASE_POSTER_URL + movie.posterPath)
                    .into(favoriteMoviePoster)
                favoriteMoviesFavIcon.setOnClickListener {
                    onUnFavorite(movie.id)
                }
            }
        }
    }
}