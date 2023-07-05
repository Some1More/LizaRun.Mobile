package com.example.lizarun.domain.model

sealed interface ApiResult<out T> {
    object Loading : ApiResult<Nothing>

    data class Success<out T>(
        val data: T
    ) : ApiResult<T>

    data class Failure(
        val message: String?,
        val errorCode: Int
    ) : ApiResult<Nothing>
}