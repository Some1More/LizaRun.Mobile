package com.example.lizarun.domain.model.entity

data class AuthData(
    val userId: String,
    val expiresIn: Int,
    val tokenType: String,
    val accessToken: String,
    val refreshToken: String
)