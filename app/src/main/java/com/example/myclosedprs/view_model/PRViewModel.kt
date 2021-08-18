package com.example.myclosedprs.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myclosedprs.network.ApiHelper
import com.example.myclosedprs.network.BaseResponse
import kotlinx.coroutines.Dispatchers

class PRViewModel(private val apiHelper: ApiHelper) : ViewModel() {

    fun getAllClosedPRs() = liveData(Dispatchers.IO) {
        emit(BaseResponse.loading(data = null))
        try {
            emit(BaseResponse.success(data = apiHelper.getAllClosedPrs()))
        } catch (exception: Exception) {
            emit(
                BaseResponse.failure(
                    data = null,
                    message = exception.message ?: "Something went wrong!"
                )
            )
        }
    }
}