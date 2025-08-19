package com.example.chukaokoyecsandroidtechtest2025.ui.model

sealed class CreditScoreUIState {
    data object Loading : CreditScoreUIState()
    data class Success (
        val userScore: CreditInfoUIModel
    ): CreditScoreUIState()
    data class Error(val message: String) : CreditScoreUIState()
}