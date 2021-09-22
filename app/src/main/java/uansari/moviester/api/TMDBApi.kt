package uansari.moviester.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uansari.moviester.BuildConfig
import uansari.moviester.data.models.detail.DetailMovieResponse
import uansari.moviester.data.models.upcoming.UpcomingMovieResponse

interface TMDBApi {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String = BuildConfig.IMDB_API_KEY
    ): UpcomingMovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(
        @Path("movie_id") movie_id: String,
        @Query("api_key") api_key: String = BuildConfig.IMDB_API_KEY,
    ): DetailMovieResponse
}