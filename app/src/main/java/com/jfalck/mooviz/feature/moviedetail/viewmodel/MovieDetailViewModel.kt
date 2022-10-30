package com.jfalck.mooviz.feature.moviedetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jfalck.domain.usecases.moviedetail.GetMovieDetailUseCase
import com.jfalck.mooviz.BuildConfig
import com.jfalck.mooviz.feature.moviedetail.wrapper.MovieDetailViewWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    private val movieDetailLiveData = MutableLiveData<MovieDetailViewWrapper>()
    private val errorLiveData = MutableLiveData<String>()

    fun getMovieDetailLiveData(): LiveData<MovieDetailViewWrapper> = movieDetailLiveData
    fun getErrorLiveData(): LiveData<String> = errorLiveData

    fun getMovieDetail(movieId: Int) {
        launch {
            try {
                val movie = MovieDetailViewWrapper(
                    getMovieDetailUseCase.invoke(
                        BuildConfig.API_KEY,
                        Locale.getDefault().language,
                        movieId
                    )
                )

                movieDetailLiveData.postValue(movie)
            } catch (e: Exception) {
                errorLiveData.postValue(e.message)
            }
        }
    }

}