package com.example.lizarun.domain.model.param

data class UpdateExerciseParam(
    val id: String,
    val name: String,
    val description: String,
    val recommendations: String,
    val exerciseType: Int,
    val muscularApparatus: Int,
    val photo: String,
    val video: String
)
