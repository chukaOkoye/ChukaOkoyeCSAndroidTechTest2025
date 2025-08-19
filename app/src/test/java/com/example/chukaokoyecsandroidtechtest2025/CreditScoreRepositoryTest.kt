package com.example.chukaokoyecsandroidtechtest2025

import com.example.chukaokoyecsandroidtechtest2025.data.api.ApiService
import com.example.chukaokoyecsandroidtechtest2025.data.repository.CreditScoreRepositoryImpl
import com.example.chukaokoyecsandroidtechtest2025.support.MockedScores
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import retrofit2.HttpException


class CreditScoreRepositoryTest {

    @get:Rule
    val rule: TestRule = CoroutineTestRule()

    private val service: ApiService = mock()

    private lateinit var repository: CreditScoreRepositoryImpl

    @Before
    fun setUp() {
        repository = CreditScoreRepositoryImpl(service)
    }

    @Test
    fun `getCreditScore returns expected CreditScore`() = runTest {
        whenever(service.getScore()).thenReturn(MockedScores.mockCreditScore)

        val result = repository.getCreditScore()

        assertThat(result.isSuccess).isTrue()
    }

    @Test(expected = HttpException::class)
    fun `getCreditScore throws an exception`() = runTest {
        whenever(service.getScore()).thenAnswer { throw HttpException(mock()) }

        repository.getCreditScore()

    }


}