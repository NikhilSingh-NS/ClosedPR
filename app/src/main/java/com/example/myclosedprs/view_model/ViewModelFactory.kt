package com.example.myclosedprs.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myclosedprs.network.ApiHelper

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PRViewModel::class.java)) {
            return PRViewModel(apiHelper) as T
        }
        throw IllegalArgumentException("Unknown class")
    }

}