package app.el_even.fdj.presentation.team_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.el_even.fdj.common.Resource
import app.el_even.fdj.domain.use_case.get_team.GetTeamUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamUC: GetTeamUC,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(TeamState())
    val state: State<TeamState> = _state

    private fun getTeam(name: String) {
        getTeamUC(name).onEach { result ->
            when (result) {
                is Resource.Error -> _state.value =
                    TeamState(error = result.message ?: "An unexpected error happened")
                is Resource.Loading -> _state.value = TeamState(isLoading = true)
                is Resource.Success -> _state.value = TeamState(team = result.data)
            }
        }.launchIn(viewModelScope)
    }

}