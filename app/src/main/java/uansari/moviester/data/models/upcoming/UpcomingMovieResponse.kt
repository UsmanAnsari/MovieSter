package uansari.moviester.data.models.upcoming


import com.google.gson.annotations.SerializedName

data class UpcomingMovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)