package com.jfalck.mooviz.feature.favoritemovies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jfalck.domain.usecases.favoritemovies.GetFavoriteMoviesUseCase
import com.jfalck.domain.usecases.favoritemovies.RemoveFavoriteMovieUseCase
import com.jfalck.mooviz.feature.favoritemovies.wrapper.FavoriteMovieWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
    private val removeFavoriteMovieUseCase: RemoveFavoriteMovieUseCase
) : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    val favoriteMoviesLiveData = MutableLiveData<List<FavoriteMovieWrapper>>()

    val errorMessageLiveData = MutableLiveData<String>()

    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() =
        launch {
            try {
                getFavoriteMoviesUseCase().collectLatest { favoriteMovies ->
                    favoriteMoviesLiveData.postValue(favoriteMovies.map { FavoriteMovieWrapper(it) })
                }
            } catch (e: Exception) {
                errorMessageLiveData.postValue(e.message)
            }
        }

    fun removeFavorite(movieId: Int) =
        launch {
            try {
                removeFavoriteMovieUseCase(movieId)
            } catch (e: Exception) {
                errorMessageLiveData.postValue(e.message)
            }
        }
}