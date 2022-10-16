package com.jfalck.mooviz.feature.topmovies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopMoviesViewModel @Inject constructor(
    //private val repository: ExampleRepository
) : ViewModel() {

    val textSampleLiveData = MutableLiveData("The Imitation Game")
}
