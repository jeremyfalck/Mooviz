package com.jfalck.mooviz.feature.moviedetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.jfalck.mooviz.common.setVisible
import com.jfalck.mooviz.databinding.FragmentMovieDetailBinding
import com.jfalck.mooviz.feature.moviedetail.viewmodel.MovieDetailViewModel
import com.jfalck.mooviz.feature.moviedetail.wrapper.MovieDetailViewWrapper
import dagger.hilt.android.AndroidEntryPoint

const val MOVIE_ID_KEY = "movieId"

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    private val movieDetailViewModel: MovieDetailViewModel by viewModels()

    private lateinit var snackbar: Snackbar

    private val genresAdapter = GenresAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentMovieDetailBinding.inflate(layoutInflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveDatas()
        initView()
        movieDetailViewModel.getMovieDetail(arguments?.getInt(MOVIE_ID_KEY) ?: 0)
    }

    private fun observeLiveDatas() {
        movieDetailViewModel.getErrorLiveData().observe(viewLifecycleOwner) {
            if (::snackbar.isInitialized) {
                snackbar.setText(it).show()
            }
        }

        movieDetailViewModel.getMovieDetailLiveData().observe(viewLifecycleOwner) {
            binding.movieDetailWrapper = it
            manageViewWithWrapper(it)
        }
    }

    private fun initView() {
        snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_SHORT)
        initGenresRecyclerView()
    }

    private fun initGenresRecyclerView() {
        binding.fragmentMovieDetailGenresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = genresAdapter

            addItemDecoration(GenresItemDecoration())
        }
    }

    private fun manageViewWithWrapper(wrapper: MovieDetailViewWrapper) {
        Glide.with(requireContext()).load(wrapper.getPosterPath())
            .into(binding.fragmentMovieDetailPoster)

        genresAdapter.genres = wrapper.getGenres()

        manageFieldsVisibility(wrapper)
    }

    private fun manageFieldsVisibility(wrapper: MovieDetailViewWrapper) {
        binding.apply {
            fragmentMovieDetailTagline.setVisible(wrapper.getTagline().isNotEmpty())

            fragmentMovieDetailOverviewContainer.setVisible(wrapper.getMovieOverview().isNotEmpty())

            fragmentMovieDetailReleaseDateContainer.setVisible(
                wrapper.getReleaseDate().isNotEmpty()
            )

            fragmentMovieDetailAverageVoteContainer.setVisible(
                wrapper.getVoteAverage().isNotEmpty()
            )

            fragmentMovieDetailVoteCountContainer.setVisible(wrapper.getVoteCount().isNotEmpty())

            fragmentMovieDetailRuntimeContainer.setVisible(wrapper.getRuntime().isNotEmpty())

            fragmentMovieDetailBudgetContainer.setVisible(wrapper.getBudget().isNotEmpty())

            fragmentMovieDetailRevenueContainer.setVisible(wrapper.getRevenue().isNotEmpty())
        }
    }
}