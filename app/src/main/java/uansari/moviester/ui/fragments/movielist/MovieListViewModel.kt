package uansari.moviester.ui.fragments.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uansari.moviester.data.models.upcoming.Result
import uansari.moviester.repositories.ApiRepository
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    ViewModel() {
    private val resultLiveData = MutableLiveData<List<Result>>()
    val result: LiveData<List<Result>> = resultLiveData

    init {
        viewModelScope.launch {
            val resultList = apiRepository.getUpcomingMovies().results
            delay(1500)
            resultLiveData.value = resultList
        }
    }
}