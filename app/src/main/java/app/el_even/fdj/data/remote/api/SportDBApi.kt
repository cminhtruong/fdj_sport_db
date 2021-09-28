package app.el_even.fdj.data.remote.api

import app.el_even.fdj.data.remote.dto.LeagueDto
import app.el_even.fdj.data.remote.dto.TeamDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SportDBApi {

    @GET("/api/v1/json/1/search_all_teams.php")
    suspend fun getTeamsFromLeague(@Query(value = "l") leagueName: String): List<TeamDto>

    @GET("/api/v1/json/1/all_leagues.php")
    suspend fun getAllLeagues(): List<LeagueDto>

    @GET("/api/v1/json/1/searchteams.php")
    suspend fun getTeamFromName(@Query(value = "t") team: String): TeamDto
}
