package com.example.lizarun.domain.model.entity

data class Exercise(
    val name: String,
    val description: String,
    val recommendations: String,
    val exerciseType: Int,
    val muscularApparatus: Int,
    val photo: String,
    val video: String,
    val id: String
)