package com.jfalck.domain.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jfalck.domain.repository.MoviesRepository

class TopMoviesPagingSource(
    private val moviesRepository: MoviesRepository,
    private var apiKey: String = "",
    private var isoLanguage: String = "en"
) : PagingSource<Int, TopMovie>() {


    override fun getRefreshKey(state: PagingState<Int, TopMovie>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopMovie> {
        val page = params.key ?: 1

        return try {
            val remoteEntity =
                moviesRepository.getTopMovies(apiKey, isoLanguage, page)
            toLoadResult(remoteEntity, page)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun toLoadResult(
        rawData: TopMovies,
        page: Int
    ): LoadResult<Int, TopMovie> {
        return LoadResult.Page(
            data = rawData.results,
            prevKey = if (page == 1) null else page - 1,
            nextKey = if (page == rawData.totalPages) null else page + 1
        )
    }
}