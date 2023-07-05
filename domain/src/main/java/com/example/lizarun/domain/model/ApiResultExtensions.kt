package com.example.lizarun.domain.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform


fun <T : Any> ApiResult<T>.onLoading(
    executable: () -> Unit
): ApiResult<T> = apply {
    if (this is ApiResult.Loading) {
        executable()
    }
}

fun <T : Any> ApiResult<T>.onSuccess(
    executable: (T?) -> Unit
): ApiResult<T> = apply {
    if (this is ApiResult.Success<T>) {
        executable(data)
    }
}

fun <T : Any> ApiResult<T>.onFailure(
    executable: (message: String?, errorCode: Int) -> Unit
): ApiResult<T> = apply {
    if (this is ApiResult.Failure) {
        executable(message, errorCode)
    }
}

fun <T> Flow<ApiResult<T>>.doOnSuccess(action: suspend (T) -> Unit) =
    transform { result ->
        if (result is ApiResult.Success) {
            action(result.data)
        }
        return@transform emit(result)
    }

fun <T> Flow<ApiResult<T>>.doOnFailure(action: suspend (message: String?, errorCode: Int) -> Unit) =
    transform { result ->
        if (result is ApiResult.Failure) {
            action(result.message, result.errorCode)
        }
        return@transform emit(result)
    }

fun <T> Flow<ApiResult<T>>.doOnLoading(action: suspend () -> Unit) =
    transform { result ->
        if (result is ApiResult.Loading) {
            action()
        }
        return@transform emit(result)
    }