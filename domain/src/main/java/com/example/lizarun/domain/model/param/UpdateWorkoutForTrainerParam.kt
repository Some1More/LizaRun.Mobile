package com.example.lizarun.domain.model.param

data class UpdateWorkoutForTrainerParam(
    val id: String,
    val name: String,
    val sportsmanId: String,
    val date: CreateDateParam,
    val workoutType: Int,
    val workoutExercises: List<CreateWorkoutExerciseParam>,
    val restTime: CreateTimeParam,
    val isWithTrainer: Boolean,
    val trainerRecommendations: String
)
