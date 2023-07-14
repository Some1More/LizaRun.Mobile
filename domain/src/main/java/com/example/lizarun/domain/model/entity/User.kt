package com.example.lizarun.domain.model.entity

data class User(
    val id: String,
    val email: String,
    val phoneNumber: String,
    val firstname: String,
    val middlename: String,
    val surname: String,
    val birthDate: Date,
    val telegramLink: String,
    val photo: String,
    val trainingComplexes: List<TrainingComplex>
)