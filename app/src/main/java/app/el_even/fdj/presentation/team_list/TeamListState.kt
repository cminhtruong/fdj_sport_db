package app.el_even.fdj.presentation.team_list

import app.el_even.fdj.domain.model.Team

data class TeamListState(
    val isLoading: Boolean = false,
    val teams: List<Team> = emptyList(),
    val error: String = ""
)
