package com.example.lizarun.domain.model.param

import com.example.lizarun.domain.model.entity.BirthDate

data class UpdateUserDataParam(
    val userId: String,
    val firstname: String,
    val middlename: String,
    val surname: String,
    val birthDate: BirthDate,
    val telegramLink: String,
    val photo: String
)