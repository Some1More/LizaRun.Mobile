package com.example.lizarun.domain.model.entity

data class WorkoutExercise(
    val id: String,
    val repetitionsCount: Int,
    val approachesCount: Int,
    val leadTime: Time,
    val distance: Int,
    val pace: Time,
    val restTime: Time,
    val exercise: ExerciseInList,
    val exercises: List<ExerciseInList>
)
