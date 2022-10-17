package com.jfalck.mooviz.feature.topmovies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalck.domain.model.Movie
import com.jfalck.domain.usecases.getTopMovies.GetTopMoviesUseCase
import com.jfalck.mooviz.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class TopMoviesViewModel @Inject constructor(
    private val getTopMoviesUseCase: GetTopMoviesUseCase
) : ViewModel() {

    val topMoviesLiveData = MutableLiveData<List<Movie>>()

    init {
        viewModelScope.launch {
            getTopMoviesUseCase(
                BuildConfig.API_KEY, Locale.getDefault().language, 1
            ).collectLatest {
                topMoviesLiveData.postValue(it.results)
            }
        }
    }
}
