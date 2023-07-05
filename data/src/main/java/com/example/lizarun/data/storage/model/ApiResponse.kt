package com.example.lizarun.data.storage.model

sealed interface ApiResponse<out T> {
    object Loading : ApiResponse<Nothing>

    data class Success<out T>(
        val data: T
    ) : ApiResponse<T>

    data class Failure(
        val message: String?,
        val errorCode: Int
    ) : ApiResponse<Nothing>
}