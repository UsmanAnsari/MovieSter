package uansari.moviester.data.models.detail


import com.google.gson.annotations.SerializedName

data class DetailMovieResponse(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double
) {
    fun getMovieBanner() = "https://image.tmdb.org/t/p/original/$backdropPath"

    fun getGenres(): String {
        var gen = ""
        genres.forEach {
            gen += "${it.name} ,"
        }
        gen = gen.drop(gen.length)
        return gen
    }

}