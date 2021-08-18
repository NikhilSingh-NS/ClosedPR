package com.example.myclosedprs.network

import com.example.myclosedprs.Status

data class BaseResponse<out T>(val status: Status, val data: T?, val msg: String?) {
    companion object {
        fun <T> success(data: T): BaseResponse<T> =
            BaseResponse(status = Status.SUCCESS, data = data, msg = null)

        fun <T> failure(data: T?, message: String): BaseResponse<T> =
            BaseResponse(status = Status.FAILURE, data = data, msg = message)

        fun <T> loading(data: T?): BaseResponse<T> =
            BaseResponse(status = Status.FAILURE, data = data, msg = null)
    }
}