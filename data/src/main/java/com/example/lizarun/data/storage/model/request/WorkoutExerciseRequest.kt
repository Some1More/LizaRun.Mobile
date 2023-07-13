package com.example.lizarun.data.storage.model.request

data class WorkoutExerciseRequest(
    val repetitionsCount: Int,
    val approachesCount: Int,
    val leadTime: TimeRequest,
    val distance: Int,
    val pace: TimeRequest,
    val restTime: TimeRequest,
    val exerciseId: String,
    val exerciseIds: List<String>
)
