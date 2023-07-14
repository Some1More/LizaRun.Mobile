package com.example.lizarun.domain.model.entity

data class WorkoutInList(
    val id: String,
    val name: String,
    val date: Date,
    val sportsmanId: String,
    val workoutType: Int,
    val executionStatus: Int
)