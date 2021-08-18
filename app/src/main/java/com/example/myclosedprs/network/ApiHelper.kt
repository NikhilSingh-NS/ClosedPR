package com.example.myclosedprs.network

class ApiHelper(private val apiClient: ApiClient) {
    suspend fun getAllClosedPrs() = apiClient.getAllClosedPRs()
}