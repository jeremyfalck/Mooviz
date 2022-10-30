package com.jfalck.mooviz.feature.moviedetail.wrapper

import com.jfalck.domain.constants.MovieConstants.BASE_POSTER_URL
import com.jfalck.domain.model.Movie
import java.text.SimpleDateFormat
import java.util.Locale

private const val FROM_DATE_FORMAT = "yyyy-MM-dd"
private const val TO_DATE_FORMAT = "dd/MM/yyyy"

/*
*  This class is used to wrap the Movie object from the domain layer
*  It bears the responsibility of formatting the data to be displayed in the UI
*/
class MovieDetailViewWrapper(private val movie: Movie) {

    private val fromReleaseDateFormat = SimpleDateFormat(FROM_DATE_FORMAT, Locale.getDefault())
    private val toReleaseDateFormat = SimpleDateFormat(TO_DATE_FORMAT, Locale.getDefault())

    fun getTitle() = movie.title

    fun getMovieOverview(): String = movie.overview ?: ""

    fun getTagline() = movie.tagline?.takeIf { it.isNotEmpty() }?.run { "\"$this\"" } ?: ""

    fun getGenres() = movie.genres.mapNotNull { it.name }

    fun getPosterPath() = movie.posterPath?.run {
        BASE_POSTER_URL + this
    } ?: ""

    fun getReleaseDate(): String = try {
        // Formatting date in new format. If the operation fails, the original date is returned
        val date = fromReleaseDateFormat.parse(movie.releaseDate ?: "")
        if (date != null) {
            "Le" + " " + toReleaseDateFormat.format(date)
        } else {
            movie.releaseDate?.let { "Le $it" } ?: ""
        }
    } catch (e: Exception) {
        movie.releaseDate?.let { "Le $it" } ?: ""
    }

    fun getVoteAverage(): String = movie.voteAverage?.run { toString() + "/" + "10" } ?: ""

    fun getVoteCount(): String = movie.voteCount?.run { toString() } ?: ""

    fun getRuntime(): String = movie.runtime?.run { toString() + " " + "minutes" } ?: ""

    fun getRevenue(): String =
        movie.revenue?.takeIf { it != 0 }?.run { toString() + " " + "$" } ?: ""

    fun getBudget(): String = movie.budget?.takeIf { it != 0 }?.run { toString() + " " + "$" } ?: ""
}