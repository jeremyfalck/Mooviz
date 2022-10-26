package com.jfalck.mooviz.feature.favoritemovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.jfalck.mooviz.databinding.FragmentFavoriteMoviesBinding
import com.jfalck.mooviz.feature.favoritemovies.ui.adapter.FavoriteMoviesAdapter
import com.jfalck.mooviz.feature.favoritemovies.viewmodel.FavoriteMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMoviesBinding

    private val favoriteMoviesViewModel: FavoriteMoviesViewModel by viewModels()

    @Inject
    lateinit var adapter: FavoriteMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentFavoriteMoviesBinding.inflate(layoutInflater).let {
            binding = it
            it.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.favoriteMoviesFragmentRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@FavoriteMoviesFragment.adapter
        }

        favoriteMoviesViewModel.favoriteMoviesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}