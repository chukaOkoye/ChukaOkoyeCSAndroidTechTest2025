package com.example.chukaokoyecsandroidtechtest2025.data.repository

import com.example.chukaokoyecsandroidtechtest2025.data.api.ApiService
import com.example.chukaokoyecsandroidtechtest2025.data.model.CreditScore
import com.example.chukaokoyecsandroidtechtest2025.domain.repository.CreditScoreRepository
import java.io.IOException
import javax.inject.Inject

class CreditScoreRepositoryImpl @Inject constructor(private val apiService: ApiService): CreditScoreRepository {
    override suspend fun getCreditScore(): Result<CreditScore> {
        return try{
            val response = apiService.getScore()
            Result.success(response)
        } catch (e: IOException){
            Result.failure(e)
        }
    }


}