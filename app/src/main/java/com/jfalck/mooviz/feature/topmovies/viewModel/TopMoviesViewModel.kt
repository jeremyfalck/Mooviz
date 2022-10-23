package com.jfalck.mooviz.feature.topmovies.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.jfalck.domain.model.TopMovie
import com.jfalck.domain.usecases.favoritemovies.SetFavoriteMovieUseCase
import com.jfalck.domain.usecases.topmovies.GetTopMoviesUseCase
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
    private val getTopMoviesUseCase: GetTopMoviesUseCase,
    private val setFavoriteMovieUseCase: SetFavoriteMovieUseCase
) : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    companion object {
        private const val FIRST_PAGE = 1
    }

    val topMoviesPagingLiveData = MutableLiveData<PagingData<TopMovie>>()

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

    fun setFavorite(movieId: Int, isFavorite: Boolean) {
        launch {
            setFavoriteMovieUseCase.invoke(
                BuildConfig.API_KEY,
                Locale.getDefault().language,
                movieId,
                isFavorite
            )
        }
    }
}
