package com.jfalck.domain.usecases.getTopMovies

import com.jfalck.domain.repository.MoviesRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetTopMoviesUseCaseImpl @Inject constructor(private val repository: MoviesRepository) :
    GetTopMoviesUseCase {
    override suspend operator fun invoke(apiKey: String, language: String, page: Int) =
        repository.getTopMovies(apiKey, language, page)
}