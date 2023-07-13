package com.example.lizarun.data.storage.model.request

data class UpdateWorkoutForSportsmanRequest(
    val workoutExercises: List<WorkoutExerciseRequest>,
    val restTime: TimeRequest,
    val sportsmanComments: String
)
