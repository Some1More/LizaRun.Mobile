package com.example.lizarun.domain.model.entity

data class TrainingComplex(
    val exercises: List<ExerciseInList>,
    val muscularApparatus: Int,
    val authorId: String,
    val author: Author
)
