package app.el_even.fdj.domain.use_case.get_team

import app.el_even.fdj.common.Resource
import app.el_even.fdj.data.remote.dto.toTeam
import app.el_even.fdj.domain.model.Team
import app.el_even.fdj.domain.repository.FDJRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamUC @Inject constructor(
    private val repository: FDJRepository
) {
    operator fun invoke(name: String): Flow<Resource<Team>> = flow {
        try {
            emit(Resource.Loading<Team>())
            val team = repository.getTeamByName(team = name).toTeam()
            emit(Resource.Success<Team>(team))
        } catch (e: HttpException) {
            emit(Resource.Error<Team>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<Team>("Couldn't reach server. Check your internet connection."))
        }
    }
}