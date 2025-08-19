package com.example.chukaokoyecsandroidtechtest2025.domain.repository

import com.example.chukaokoyecsandroidtechtest2025.data.model.CreditScore

interface CreditScoreRepository {

    suspend fun getCreditScore(): Result<CreditScore>
}