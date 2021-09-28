package app.el_even.fdj.presentation.league_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.el_even.fdj.common.Resource
import app.el_even.fdj.domain.use_case.get_all_leagues.GetAllLeaguesUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LeagueListViewModel @Inject constructor(
    private val getAllLeaguesUC: GetAllLeaguesUC
) : ViewModel() {

    private val _state = mutableStateOf(LeagueListState())
    val state: State<LeagueListState> = _state

    init {
        getLeagues()
    }

    private fun getLeagues() {
        getAllLeaguesUC().onEach { result ->
            when (result) {
                is Resource.Success -> _state.value =
                    LeagueListState(leagues = result.data ?: emptyList())
                is Resource.Error -> _state.value =
                    LeagueListState(error = result.message ?: "An unexpected error happened")
                is Resource.Loading -> _state.value = LeagueListState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}