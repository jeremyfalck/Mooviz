package com.jfalck.mooviz.feature.topmovies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.jfalck.domain.model.Movie
import com.jfalck.domain.usecases.getTopMovies.GetTopMoviesUseCase
import com.jfalck.mooviz.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@HiltViewModel
class TopMoviesViewModel @Inject constructor(
    private val getTopMoviesUseCase: GetTopMoviesUseCase
) : ViewModel() {

    companion object {
        private const val FIRST_PAGE = 1
    }

    val topMoviesPagingLiveData = MutableLiveData<PagingData<Movie>>()

    var page = FIRST_PAGE

    init {
        viewModelScope.launch {
            getTopMoviesUseCase(
                BuildConfig.API_KEY, Locale.getDefault().language, page
            ).distinctUntilChanged().collect {
                topMoviesPagingLiveData.postValue(it)
            }
        }
    }
}
