package com.jfalck.mooviz.feature.topmovies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalck.domain.constants.MovieConstants.BASE_POSTER_URL
import com.jfalck.domain.model.Movie
import com.jfalck.mooviz.databinding.TopMovieItemBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import kotlin.random.Random


@FragmentScoped
class TopMoviesPagerAdapter @Inject constructor() :
    PagingDataAdapter<Movie, TopMoviesPagerAdapter.TopMovieViewHolder>(TopMoviesDiffCallback()) {

    var onFavoriteSelectedListener: ((Int, Boolean) -> Unit) = { _, _ -> }

    inner class TopMovieViewHolder(val binding: TopMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
        setAnimation(holder.itemView, position)
        getItem(position)?.let { item ->
            holder.binding.topMovieItemTitle.text = item.title
            Glide.with(holder.itemView.context).load(BASE_POSTER_URL + item.posterPath)
                .into(holder.binding.topMoviePoster)
            holder.binding.topMoviesFavIcon.setOnClickListener {
                onFavoriteSelectedListener(item.id, true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder =
        TopMovieViewHolder(
            TopMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    private var mLastPosition = -1

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > mLastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = Random.nextLong(501) //to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            mLastPosition = position
        }
    }
}