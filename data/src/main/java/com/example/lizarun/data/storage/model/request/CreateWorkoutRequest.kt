package com.example.lizarun.data.storage.model.request

data class CreateWorkoutRequest(
    val name: String,
    val sportsmanId: String,
    val date: DateRequest,
    val workoutType: Int,
    val restTime: TimeRequest,
    val isWithTrainer: Boolean,
    val trainerRecommendations: String,
    val workoutExercises: List<WorkoutExerciseRequest>
)
