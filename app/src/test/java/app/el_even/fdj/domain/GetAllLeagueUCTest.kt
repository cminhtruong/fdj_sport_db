package app.el_even.fdj.domain

import app.el_even.fdj.common.Resource
import app.el_even.fdj.data.remote.dto.LeagueDto
import app.el_even.fdj.domain.repository.FDJRepository
import app.el_even.fdj.domain.use_case.get_all_leagues.GetAllLeaguesUC
import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAllLeagueUCTest {

    private val fdjRepository: FDJRepository = mockk()
    private val classTest = GetAllLeaguesUC(fdjRepository)

    @Before
    fun setup() {
        clearAllMocks()
    }

    @Test
    fun `Get All Leagues with successful`() {
        val expectedResult = listOf<LeagueDto>()
        coEvery { fdjRepository.getLeagues() } returns expectedResult

        val result = classTest.invoke()

        assertEquals(expectedResult, result)
        coVerify(exactly = 1) {
            fdjRepository.getLeagues()
        }
        confirmVerified(fdjRepository)
    }
}