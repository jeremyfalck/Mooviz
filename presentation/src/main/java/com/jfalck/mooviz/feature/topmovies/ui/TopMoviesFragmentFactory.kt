package com.jfalck.mooviz.feature.topmovies.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class TopMoviesFragmentFactory @Inject constructor(
    // your dependencies
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =
        when (className) {
            TopMoviesFragment::class.java.name -> TopMoviesFragment()
            // here you can add every other fragment
            else -> super.instantiate(classLoader, className)
        }
}
