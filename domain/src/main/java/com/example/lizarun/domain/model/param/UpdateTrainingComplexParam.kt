package com.example.lizarun.domain.model.param

data class UpdateTrainingComplexParam(
    val id: String,
    val exercises: List<CreateExerciseParam>,
    val muscularApparatus: Int
)
