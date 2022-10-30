package com.jfalck.mooviz.feature.favoritemovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jfalck.mooviz.R
import com.jfalck.mooviz.databinding.FragmentFavoriteMoviesBinding
import com.jfalck.mooviz.feature.favoritemovies.ui.adapter.FavoriteMoviesAdapter
import com.jfalck.mooviz.feature.favoritemovies.viewmodel.FavoriteMoviesViewModel
import com.jfalck.mooviz.feature.moviedetail.ui.MOVIE_ID_KEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMoviesBinding

    private val favoriteMoviesViewModel: FavoriteMoviesViewModel by viewModels()

    @Inject
    lateinit var adapter: FavoriteMoviesAdapter

    private lateinit var snackbar: Snackbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentFavoriteMoviesBinding.inflate(layoutInflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveDatas()
    }

    private fun initView() {
        snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_SHORT)
        binding.favoriteMoviesFragmentRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@FavoriteMoviesFragment.adapter.apply {
                onUnFavorite = { movieId -> favoriteMoviesViewModel.removeFavorite(movieId) }
                onItemSelected = { movieId ->
                    findNavController().navigate(R.id.action_favoriteMoviesFragment_to_movieDetailFragment,
                        Bundle().apply {
                            putInt(MOVIE_ID_KEY, movieId)
                        })
                }
            }
        }
    }

    private fun observeLiveDatas() {
        favoriteMoviesViewModel.favoriteMoviesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        favoriteMoviesViewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            if (::snackbar.isInitialized) {
                snackbar.setText(it).show()
            }
        }
    }
}