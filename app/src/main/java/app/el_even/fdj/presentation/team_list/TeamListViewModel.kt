package app.el_even.fdj.presentation.team_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import app.el_even.fdj.common.Resource
import app.el_even.fdj.domain.use_case.get_league.GetLeagueUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel @Inject constructor(
    private val getLeagueUC: GetLeagueUC
) : ViewModel() {

    private val _state = mutableStateOf(TeamListState())
    val state: State<TeamListState> = _state

    private fun getLeague(name: String) {
        getLeagueUC(name).onEach { result ->
            when (result) {
                is Resource.Error -> TODO()
                is Resource.Loading -> TODO()
                is Resource.Success -> TODO()
            }
        }
    }
}