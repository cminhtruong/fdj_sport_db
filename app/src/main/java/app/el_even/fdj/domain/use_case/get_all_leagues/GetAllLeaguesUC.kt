package app.el_even.fdj.domain.use_case.get_all_leagues

import app.el_even.fdj.common.Resource
import app.el_even.fdj.data.remote.dto.toLeague
import app.el_even.fdj.domain.model.League
import app.el_even.fdj.domain.repository.FDJRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllLeaguesUC @Inject constructor(
    private val repository: FDJRepository
) {
    operator fun invoke(): Flow<Resource<List<League>>> = flow {
        try {
            emit(Resource.Loading<List<League>>())
            val leagues = repository.getLeagues().map { it.toLeague() }
            emit(Resource.Success<List<League>>(leagues))
        } catch (e: HttpException) {
            emit(Resource.Error<List<League>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<League>>("Couldn't reach server. Check your internet connection."))
        }
    }
}