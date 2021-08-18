package com.example.myclosedprs.network

import com.example.myclosedprs.model.PRModel
import retrofit2.http.GET

interface ApiClient {
    @GET("pulls?state=closed")
    suspend fun getAllClosedPRs(): List<PRModel>
}