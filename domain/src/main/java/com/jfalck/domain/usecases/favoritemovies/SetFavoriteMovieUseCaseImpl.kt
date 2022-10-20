package com.jfalck.domain.usecases.favoritemovies

import com.jfalck.domain.repository.MoviesRepository
import javax.inject.Inject

class SetFavoriteMovieUseCaseImpl @Inject constructor(
    private val moviesRepository: MoviesRepository,
) : SetFavoriteMovieUseCase {
    override fun invoke(movieId: Int, isFavorite: Boolean) {
        if (isFavorite) {
            // TODO get movie from remote and save movie in local
        } else {
            // TODO get movie from db and delete it if not favorite
        }
    }
}