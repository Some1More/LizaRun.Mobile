package com.example.lizarun.domain.model.param

data class CreateExerciseParam(
    val name: String,
    val description: String,
    val recommendations: String,
    val exerciseType: Int,
    val muscularApparatus: Int,
    val photo: String,
    val video: String
)
