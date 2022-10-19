package com.jfalck.mooviz.feature.topmovies.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.jfalck.domain.model.Movie
import com.jfalck.domain.usecases.getTopMovies.GetTopMoviesUseCase
import com.jfalck.mooviz.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@HiltViewModel
class TopMoviesViewModel @Inject constructor(
    private val getTopMoviesUseCase: GetTopMoviesUseCase
) : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    companion object {
        private const val FIRST_PAGE = 1
    }

    val topMoviesPagingLiveData = MutableLiveData<PagingData<Movie>>()

    var page = FIRST_PAGE

    init {
        launch {
            getTopMoviesUseCase(
                BuildConfig.API_KEY, Locale.getDefault().language, page
            ).distinctUntilChanged().collect {
                Log.d("TopMoviesViewModel", "collect")
                topMoviesPagingLiveData.postValue(it)
            }
        }
    }
}
