package com.example.lizarun.domain.model.param

data class UpdateSportsmanDataParam(
    val sportsmanId: String,
    val trainerId: String,
    val bibNumber: Int,
    val height: Int,
    val width: Int,
    val sportClass: Int,
    val baseDistances: List<Int>,
    val trainingPurpose: String,
    val peculiarities: String,
    val teamId: String
)
