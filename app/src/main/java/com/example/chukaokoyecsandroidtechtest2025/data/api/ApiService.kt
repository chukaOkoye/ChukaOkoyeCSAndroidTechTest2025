package com.example.chukaokoyecsandroidtechtest2025.data.api

import com.example.chukaokoyecsandroidtechtest2025.data.model.CreditScore
import retrofit2.http.GET

interface ApiService {

    @GET("endpoint.json")
    suspend fun getScore(): CreditScore

    companion object {
        const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"
    }
}
