package com.example.lizarun.domain.model.param

data class CreateTrainingComplexParam(
    val exercises: List<CreateExerciseParam>,
    val muscularApparatus: Int
)
