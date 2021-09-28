package app.el_even.fdj.domain.repository

import app.el_even.fdj.data.remote.dto.LeagueDto
import app.el_even.fdj.data.remote.dto.TeamDto

interface FDJRepository {

    suspend fun getTeamsByLeague(league: String): List<TeamDto>

    suspend fun getLeagues(): List<LeagueDto>

    suspend fun getTeamByName(team: String): TeamDto
}