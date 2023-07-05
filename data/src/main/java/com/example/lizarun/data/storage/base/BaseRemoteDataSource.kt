package com.example.lizarun.data.storage.base

import android.content.Context
import com.example.lizarun.data.storage.TokenLocalDataSource
import com.example.lizarun.data.storage.model.ApiResponse
import com.example.lizarun.data.storage.retrofit.LizaRunApiClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import okio.IOException
import retrofit2.Call
import retrofit2.HttpException
import timber.log.Timber

abstract class BaseRemoteDataSource(context: Context) {
    protected val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    protected suspend fun <T> apiRequestFlow(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        call: suspend () -> Call<T>
    ): Flow<ApiResponse<T>> = flow {
        emit(ApiResponse.Loading)

        withTimeoutOrNull(20000L) {
            try {
                val response = call().execute()
                Timber.d("Response: $response")

                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null)
                        emit(ApiResponse.Success(data))
                    else {
                        val error = response.errorBody()
                        if (error != null) {
                            emit(
                                ApiResponse.Failure(
                                    message = error.toString(),
                                    errorCode = 400
                                )
                            )
                        } else {
                            emit(
                                ApiResponse.Failure(
                                    message = "Something went wrong!",
                                    errorCode = 400
                                )
                            )
                        }
                    }
                } else {
                    emit(
                        ApiResponse.Failure(
                            message = response.message(),
                            errorCode = response.code()
                        )
                    )
                }
            } catch (e: HttpException) {
                emit(
                    ApiResponse.Failure(
                        message = e.message(),
                        errorCode = e.code()
                    )
                )
            } catch (e: IOException) {
                emit(
                    ApiResponse.Failure(
                        message = e.message,
                        errorCode = 404
                    )
                )
            } catch (e: Exception) {
                Timber.e(e, e.message)
                emit(
                    ApiResponse.Failure(
                        message = e.message,
                        errorCode = 400
                    )
                )
            }
        } ?: emit(
            ApiResponse.Failure(
                message = "Timeout!",
                errorCode = 408
            )
        )
    }.flowOn(dispatcher)
}