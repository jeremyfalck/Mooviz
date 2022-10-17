package com.jfalck.mooviz.feature.topmovies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalck.domain.model.TopMovies
import com.jfalck.domain.usecases.getTopMovies.GetTopMoviesUseCase
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
                "10cae2db97999dfcdfe05b0078e57b03", Locale.getDefault().language, 1
            ).collectLatest {
                topMoviesLiveData.postValue(it)
            }
        }
    }
}
