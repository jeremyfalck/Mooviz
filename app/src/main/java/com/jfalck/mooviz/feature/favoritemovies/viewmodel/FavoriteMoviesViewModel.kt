package com.jfalck.mooviz.feature.favoritemovies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jfalck.domain.model.Movie
import com.jfalck.domain.usecases.favoritemovies.GetFavoriteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    val favoriteMoviesLiveData = MutableLiveData<List<Movie>>()

    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() {
        launch {
            getFavoriteMoviesUseCase().collectLatest {
                favoriteMoviesLiveData.postValue(it)
            }
        }
    }

}