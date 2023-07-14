package com.example.lizarun.domain.model.param

data class CreateWorkoutParam(
    val name: String,
    val sportsmanId: String,
    val date: CreateDateParam,
    val workoutType: Int,
    val restTime: CreateTimeParam,
    val isWithTrainer: Boolean,
    val trainerRecommendations: String,
    val workoutExercises: List<CreateWorkoutExerciseParam>
)
