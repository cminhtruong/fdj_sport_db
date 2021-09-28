package app.el_even.fdj.presentation.team_detail

import app.el_even.fdj.domain.model.Team

data class TeamState(
    val isLoading: Boolean = false,
    val team: Team? = null,
    val error: String = ""
)