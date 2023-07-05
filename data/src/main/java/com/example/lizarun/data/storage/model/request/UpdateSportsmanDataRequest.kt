package com.example.lizarun.data.storage.model.request

data class UpdateSportsmanDataRequest(
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
