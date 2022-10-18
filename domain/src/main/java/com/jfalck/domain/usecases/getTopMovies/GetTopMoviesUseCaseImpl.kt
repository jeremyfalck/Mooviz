package com.jfalck.domain.usecases.getTopMovies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jfalck.domain.model.Movie
import com.jfalck.domain.model.TopMoviesPagingSource
import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.getTopMovies.TopMoviesValues.INITIAL_LOAD_SIZE
import com.jfalck.domain.usecases.getTopMovies.TopMoviesValues.PAGE_SIZE
import com.jfalck.domain.usecases.getTopMovies.TopMoviesValues.PREFETCH_DISTANCE
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
    ): Flow<PagingData<Movie>> {

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