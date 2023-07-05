package com.example.lizarun.data.storage.model.request

data class CreateExerciseRequest(
    val name: String,
    val description: String,
    val recommendations: String,
    val exerciseType: Int,
    val muscularApparatus: Int,
    val photo: String,
    val video: String
)
