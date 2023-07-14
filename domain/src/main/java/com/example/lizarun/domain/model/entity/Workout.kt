package com.example.lizarun.domain.model.entity

data class Workout(
    val id: String,
    val name: String,
    val sportsmanId: String,
    val date: Date,
    val workoutType: Int,
    val restTime: Time,
    val isWithTrainer: Boolean,
    val trainerRecommendations: String,
    val workoutExercises: List<WorkoutExercise>,
    val sportsmanComments: String,
    val executionStatus: Int
)
