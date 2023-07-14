package com.example.lizarun.domain.model.param

data class UpdateWorkoutForSportsmanParam(
    val id: String,
    val workoutExercises: List<CreateWorkoutExerciseParam>,
    val restTime: CreateTimeParam,
    val sportsmanComments: String
)
