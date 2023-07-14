package com.example.lizarun.domain.model.param

import com.example.lizarun.domain.model.entity.Date

data class UpdateUserDataParam(
    val userId: String,
    val firstname: String,
    val middlename: String,
    val surname: String,
    val birthDate: Date,
    val telegramLink: String,
    val photo: String
)