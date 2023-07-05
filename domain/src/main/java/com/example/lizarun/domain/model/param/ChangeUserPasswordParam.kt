package com.example.lizarun.domain.model.param

data class ChangeUserPasswordParam(
    val email: String,
    val oldPassword: String,
    val newPassword: String
)
