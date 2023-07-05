package com.example.lizarun.data.storage.model.request

data class ChangeUserPasswordRequest(
    val email: String,
    val oldPassword: String,
    val newPassword: String
)
