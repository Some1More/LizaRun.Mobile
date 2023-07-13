package com.example.lizarun.data.storage.model.request

data class UpdateWorkoutForTrainerRequest(
    val name: String,
    val sportsmanId: String,
    val date: DateRequest,
    val workoutType: Int,
    val workoutExercises: List<WorkoutExerciseRequest>,
    val restTime: TimeRequest,
    val isWithTrainer: Boolean,
    val trainerRecommendations: String
)