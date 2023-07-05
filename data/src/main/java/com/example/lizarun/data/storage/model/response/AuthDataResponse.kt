package com.example.lizarun.data.storage.model.response

data class AuthDataResponse(
    val userId: String,
    val expiresIn: Int,
    val tokenType: String,
    val accessToken: String,
    val refreshToken: String
)