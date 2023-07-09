package com.example.lizarun.data.storage.network

import com.example.lizarun.data.storage.TokenLocalDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object LizaRunApiClient {
    private lateinit var apiService: LizaRunApiService
    private const val BASE_URL = "https://4d65-5-136-126-151.ngrok-free.app"

    fun getApiService(tokenLocalDataSource: TokenLocalDataSource): LizaRunApiService {
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient(tokenLocalDataSource))
                .build()
            apiService = retrofit.create(LizaRunApiService::class.java)
        }
        return apiService
    }

    private fun okHttpClient(tokenLocalDataSource: TokenLocalDataSource): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(AuthInterceptor(tokenLocalDataSource))
            .build()
    }
}