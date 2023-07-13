package com.example.lizarun.data.storage.model.response

data class UserResponse(
    val id: String,
    val email: String,
    val phoneNumber: String,
    val firstname: String,
    val middlename: String,
    val surname: String,
    val birthDate: DateResponse,
    val telegramLink: String,
    val photo: String,
    val trainingComplexes: List<TrainingComplexResponse>
)