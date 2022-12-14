package com.jfalck.domain.usecases.topmovies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jfalck.domain.model.TopMovie
import com.jfalck.domain.model.TopMoviesPagingSource
import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.topmovies.TopMoviesValues.INITIAL_LOAD_SIZE
import com.jfalck.domain.usecases.topmovies.TopMoviesValues.PAGE_SIZE
import com.jfalck.domain.usecases.topmovies.TopMoviesValues.PREFETCH_DISTANCE
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@ViewModelScoped
class GetTopMoviesUseCaseImpl @Inject constructor(private val repository: MoviesRepository) :
    GetTopMoviesUseCase {

    lateinit var dataSource: TopMoviesPagingSource

    override suspend operator fun invoke(
        apiKey: String,
        language: String,
        page: Int
    ): Flow<PagingData<TopMovie>> {

        dataSource = TopMoviesPagingSource(repository, apiKey, language)

        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                initialLoadSize = INITIAL_LOAD_SIZE,
                enablePlaceholders = true,
            ),
            pagingSourceFactory = {
                dataSource
            }
        ).flow
    }
}