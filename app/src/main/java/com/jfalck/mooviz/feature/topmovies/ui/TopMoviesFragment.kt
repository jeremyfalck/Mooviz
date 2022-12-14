package com.jfalck.mooviz.feature.topmovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.jfalck.mooviz.databinding.FragmentTopMoviesBinding
import com.jfalck.mooviz.feature.topmovies.ui.adapter.IS_FAVORITE_KEY
import com.jfalck.mooviz.feature.topmovies.ui.adapter.TopMoviesPagerAdapter
import com.jfalck.mooviz.feature.topmovies.viewModel.TopMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopMoviesFragment : Fragment() {

    private lateinit var binding: FragmentTopMoviesBinding

    private val topMoviesViewModel: TopMoviesViewModel by viewModels()

    @Inject
    lateinit var adapter: TopMoviesPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentTopMoviesBinding.inflate(layoutInflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.fragmentTopMoviesRecyclerView.run {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@TopMoviesFragment.adapter
        }
        topMoviesViewModel.topMoviesPagingLiveData.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
        }

        adapter.onFavoriteSelectedListener = { movieId: Int, isFavorite: Boolean ->
            topMoviesViewModel.setFavorite(movieId, isFavorite)
        }

        topMoviesViewModel.moviesChangedLiveData.observe(viewLifecycleOwner) { movieId ->
            val movie = adapter.snapshot().items.find { it.id == movieId }

            movie?.isFavorite = !(movie?.isFavorite ?: true)
            adapter.notifyItemChanged(
                adapter.snapshot().items.indexOfFirst { it.id == movieId }, IS_FAVORITE_KEY
            )
        }
    }
}