package com.example.lizarun.data.storage.model.request

data class RegisterUserRequest(
    val email: String,
    val birthDate: String,
    val password: String,
    val passwordConfirm: String,
    val role: Int
)
