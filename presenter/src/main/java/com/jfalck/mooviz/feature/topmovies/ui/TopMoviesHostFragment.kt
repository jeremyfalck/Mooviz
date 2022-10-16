package com.jfalck.mooviz.feature.topmovies.ui

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopMoviesHostFragment : NavHostFragment() {
    @Inject
    lateinit var topMoviesFragmentFactory: TopMoviesFragmentFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = topMoviesFragmentFactory
    }
}
