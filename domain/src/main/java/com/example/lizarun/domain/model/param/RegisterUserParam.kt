package com.example.lizarun.domain.model.param

data class RegisterUserParam(
    val email: String,
    val birthDate: String,
    val password: String,
    val passwordConfirm: String,
    val role: Int
)