package com.example.chukaokoyecsandroidtechtest2025.viewmodel

import com.example.chukaokoyecsandroidtechtest2025.CoroutineTestRule
import com.example.chukaokoyecsandroidtechtest2025.data.repository.CreditScoreRepositoryImpl
import com.example.chukaokoyecsandroidtechtest2025.ui.model.CreditScoreUIState
import com.example.chukaokoyecsandroidtechtest2025.support.MockedScores.mockCreditScore
import com.example.chukaokoyecsandroidtechtest2025.support.MockedScores.mockedCreditUIState
import com.example.chukaokoyecsandroidtechtest2025.ui.viewmodel.CreditScoreViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle

import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class CreditScoreViewModelTest {

    @get:Rule
    val rule: TestRule = CoroutineTestRule(StandardTestDispatcher())

    private val repository: CreditScoreRepositoryImpl = mock()

    private lateinit var viewModel: CreditScoreViewModel

    @Test
    fun `on init sets loading state`() = runTest {
        viewModel = CreditScoreViewModel(repository)

        assertThat(viewModel.uiState.first()).isEqualTo(CreditScoreUIState.Loading)
    }

    @Test
    fun `on success show success state`() = runTest {
        whenever(repository.getCreditScore()).thenReturn(Result.success(mockCreditScore))

        viewModel = CreditScoreViewModel(repository)
        viewModel.fetchCreditScore()

        advanceUntilIdle()

        assertThat(viewModel.uiState.first()).isEqualTo(CreditScoreUIState.Success(mockedCreditUIState))
    }

    @Test
    fun `on error show error state`() = runTest {
        whenever(repository.getCreditScore()).thenReturn(Result.failure(Exception("error")))

        viewModel = CreditScoreViewModel(repository)
        viewModel.fetchCreditScore()

        advanceUntilIdle()

        assertThat(viewModel.uiState.first()).isEqualTo(CreditScoreUIState.Error("error"))
    }
}