package com.jfalck.data.service

import com.jfalck.data.dto.MovieDTO
import com.jfalck.data.dto.TopMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {

    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): TopMoviesDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieFromId(
        @Path("movie_id")
        movieId: Int,
        @Query("api_key")
        apiKey: String,
        @Query("language")
        language: String
    ): MovieDTO


}