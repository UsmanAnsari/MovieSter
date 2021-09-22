package uansari.moviester.ui.fragments.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uansari.moviester.data.models.detail.DetailMovieResponse
import uansari.moviester.repositories.ApiRepository
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    ViewModel() {
    private val movieDetailLiveData = MutableLiveData<DetailMovieResponse>()
    val movieDetail: LiveData<DetailMovieResponse> = movieDetailLiveData

    fun getMoviesDetail(movie_id: String) {
        viewModelScope.launch {
            val movieDetailList = apiRepository.getMoviesDetail(movie_id)
            delay(1500)
            movieDetailLiveData.value = movieDetailList
        }
    }
}