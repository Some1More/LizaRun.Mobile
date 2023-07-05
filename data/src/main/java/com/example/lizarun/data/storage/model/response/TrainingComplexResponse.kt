package com.example.lizarun.data.storage.model.response

data class TrainingComplexResponse(
    val exercises: List<ExerciseInListResponse>,
    val muscularApparatus: Int,
    val authorId: String,
    val author: AuthorResponse
)
