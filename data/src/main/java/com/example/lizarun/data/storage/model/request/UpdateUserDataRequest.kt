package com.example.lizarun.data.storage.model.request

data class UpdateUserDataRequest(
    val firstname: String,
    val middlename: String,
    val surname: String,
    val birthDate: BirthDateRequest,
    val telegramLink: String,
    val photo: String
)
