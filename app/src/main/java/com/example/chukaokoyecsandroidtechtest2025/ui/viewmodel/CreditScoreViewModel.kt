package com.example.chukaokoyecsandroidtechtest2025.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chukaokoyecsandroidtechtest2025.data.repository.CreditScoreRepositoryImpl
import com.example.chukaokoyecsandroidtechtest2025.ui.mapper.toCreditInfoUIModel
import com.example.chukaokoyecsandroidtechtest2025.ui.model.CreditScoreUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditScoreViewModel @Inject constructor(
    private val repository: CreditScoreRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<CreditScoreUIState>(CreditScoreUIState.Loading)
    val uiState = _uiState.asStateFlow()


    fun fetchCreditScore() {
        viewModelScope.launch {
            _uiState.value = CreditScoreUIState.Loading
            val result = repository.getCreditScore()

            _uiState.value = result.fold(
                onSuccess = { score ->
                    val uiModel = score.toCreditInfoUIModel()
                    CreditScoreUIState.Success(uiModel)
                },
                onFailure = { error ->
                    CreditScoreUIState.Error(error.localizedMessage ?: "Unknown error")
                }
            )
        }
    }

}