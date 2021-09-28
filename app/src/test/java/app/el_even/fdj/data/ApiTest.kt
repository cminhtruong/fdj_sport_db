package app.el_even.fdj.data

import app.el_even.fdj.data.remote.api.SportDBApi
import app.el_even.fdj.data.repository.FDJRepositoryImpl
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.Before

class ApiTest {

    private val sportDBApi: SportDBApi = mockk()
    private val classTest = FDJRepositoryImpl(sportDBApi)

    @Before
    fun setup() {
        clearAllMocks()
    }


}