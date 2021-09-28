package app.el_even.fdj.data.repository

import app.el_even.fdj.data.remote.api.SportDBApi
import app.el_even.fdj.data.remote.dto.LeagueDto
import app.el_even.fdj.data.remote.dto.TeamDto
import app.el_even.fdj.domain.repository.FDJRepository
import javax.inject.Inject

class FDJRepositoryImpl @Inject constructor(
    private val sportDBApi: SportDBApi
) : FDJRepository {
    override suspend fun getTeamsByLeague(league: String): List<TeamDto> =
        sportDBApi.getTeamsFromLeague(leagueName = league)

    override suspend fun getLeagues(): List<LeagueDto> = sportDBApi.getAllLeagues()

    override suspend fun getTeamByName(team: String): TeamDto =
        sportDBApi.getTeamFromName(team = team)
}