package app.el_even.fdj.data.remote.dto

import app.el_even.fdj.domain.model.League

data class LeagueDto(
    val idLeague: String,
    val strLeague: String,
    val strLeagueAlternate: String,
    val strSport: String
)

fun LeagueDto.toLeague(): League = League(
    id = idLeague,
    name = strLeague
)