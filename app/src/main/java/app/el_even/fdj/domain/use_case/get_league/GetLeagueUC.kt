package app.el_even.fdj.domain.use_case.get_league

import app.el_even.fdj.common.Resource
import app.el_even.fdj.data.remote.dto.toTeam
import app.el_even.fdj.domain.model.Team
import app.el_even.fdj.domain.repository.FDJRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLeagueUC @Inject constructor(
    private val repository: FDJRepository
) {
    operator fun invoke(league: String): Flow<Resource<List<Team>>> = flow {
        try {
            emit(Resource.Loading<List<Team>>())
            val teams = repository.getTeamsByLeague(league = league).map { it.toTeam() }
            emit(Resource.Success<List<Team>>(teams))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Team>>(e.localizedMessage ?: "An unexpected error happened"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Team>>("Couldn't reach server. Check your internet connection."))
        }
    }
}