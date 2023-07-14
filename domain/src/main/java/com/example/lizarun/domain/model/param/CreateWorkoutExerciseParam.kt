package com.example.lizarun.domain.model.param

data class CreateWorkoutExerciseParam(
    val repetitionsCount: Int,
    val approachesCount: Int,
    val leadTime: CreateTimeParam,
    val distance: Int,
    val pace: CreateTimeParam,
    val restTime: CreateTimeParam,
    val exerciseId: String,
    val exerciseIds: List<String>
)
