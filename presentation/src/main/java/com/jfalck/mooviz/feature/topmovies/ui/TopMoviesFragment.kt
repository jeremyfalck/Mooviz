package com.jfalck.mooviz.feature.topmovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jfalck.mooviz.databinding.FragmentTopMoviesBinding
import com.jfalck.mooviz.feature.topmovies.viewModel.TopMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopMoviesFragment : Fragment() {

    lateinit var binding: FragmentTopMoviesBinding

    private val topMoviesViewModel: TopMoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentTopMoviesBinding.inflate(layoutInflater).let {
            binding = it
            it.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        topMoviesViewModel.textSampleLiveData.observe(viewLifecycleOwner) {
            binding.fragmentTopMoviesSampleText.text = it
        }
    }
}