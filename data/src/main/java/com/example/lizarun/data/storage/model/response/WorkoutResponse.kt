package com.example.lizarun.data.storage.model.response

data class WorkoutResponse(
    val id: String,
    val name: String,
    val sportsmanId: String,
    val date: DateResponse,
    val workoutType: Int,
    val restTime: TimeResponse,
    val isWithTrainer: Boolean,
    val trainerRecommendations: String,
    val workoutExercises: List<WorkoutExerciseResponse>,
    val sportsmanComments: String,
    val executionStatus: Int
)