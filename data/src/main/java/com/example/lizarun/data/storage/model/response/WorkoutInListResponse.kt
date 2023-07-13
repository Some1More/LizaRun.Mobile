package com.example.lizarun.data.storage.model.response

data class WorkoutInListResponse(
    val id: String,
    val name: String,
    val date: DateResponse,
    val sportsmanId: String,
    val workoutType: Int,
    val executionStatus: Int
)