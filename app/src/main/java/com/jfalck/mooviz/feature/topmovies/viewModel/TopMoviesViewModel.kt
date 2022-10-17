package com.jfalck.mooviz.feature.topmovies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalck.domain.model.TopMovies
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
    val textSampleLiveData = MutableLiveData("The Imitation Game")

    val topMoviesLiveData = MutableLiveData<TopMovies>()

    init {
        viewModelScope.launch {
            getTopMoviesUseCase(
                BuildConfig.API_KEY, Locale.getDefault().language, 1
            ).collectLatest {
                topMoviesLiveData.postValue(it)
                val titles = StringBuilder()
                it.results.forEachIndexed { index, movie ->
                    if (index != 0) {
                        titles.append(", \n")
                    }
                    titles.append(movie.title)
                }
                textSampleLiveData.postValue(titles.toString())
            }
        }
    }
}
