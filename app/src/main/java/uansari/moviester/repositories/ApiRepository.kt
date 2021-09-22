package uansari.moviester.repositories

import uansari.moviester.api.TMDBApi
import javax.inject.Inject

class ApiRepository @Inject constructor(private val tmdbApi: TMDBApi) {
    suspend fun getUpcomingMovies() = tmdbApi.getUpcomingMovies()

    suspend fun getMoviesDetail(movie_id: String) = tmdbApi.getMoviesDetail(movie_id)
}