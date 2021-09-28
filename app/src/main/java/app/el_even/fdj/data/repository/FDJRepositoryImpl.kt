package app.el_even.fdj.data.repository

import app.el_even.fdj.data.remote.api.SportDBApi
import javax.inject.Inject

class FDJRepositoryImpl @Inject constructor(
    private val sportDBApi: SportDBApi
) {
}