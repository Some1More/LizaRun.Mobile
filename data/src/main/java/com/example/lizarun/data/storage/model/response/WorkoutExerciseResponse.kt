package com.example.lizarun.data.storage.model.response

data class WorkoutExerciseResponse(
    val id: String,
    val repetitionsCount: Int,
    val approachesCount: Int,
    val leadTime: TimeResponse,
    val distance: Int,
    val pace: TimeResponse,
    val restTime: TimeResponse,
    val exercise: ExerciseInListResponse,
    val exercises: List<ExerciseInListResponse>
)