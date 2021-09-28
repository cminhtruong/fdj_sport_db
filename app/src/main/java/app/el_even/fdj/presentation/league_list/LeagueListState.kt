package app.el_even.fdj.presentation.league_list

import app.el_even.fdj.domain.model.League

data class LeagueListState(
    val isLoading: Boolean = false,
    val leagues: List<League> = emptyList(),
    val error: String = ""
)