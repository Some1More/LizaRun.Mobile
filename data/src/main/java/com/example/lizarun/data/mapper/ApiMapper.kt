package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.ApiResponse
import com.example.lizarun.domain.model.ApiResult

fun <T, R> ApiResponse<T>.map(transform: (T) -> R): ApiResult<R> {
    return when (this) {
        is ApiResponse.Success -> ApiResult.Success(transform(data))
        is ApiResponse.Failure -> ApiResult.Failure(message, errorCode)
        ApiResponse.Loading -> ApiResult.Loading
    }
}

fun <T> ApiResponse<T>.map(): ApiResult<T> {
    return when (this) {
        is ApiResponse.Success -> ApiResult.Success(data)
        is ApiResponse.Failure -> ApiResult.Failure(message, errorCode)
        ApiResponse.Loading -> ApiResult.Loading
    }
}