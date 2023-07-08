package com.example.lizarun.data.storage.model.request

data class CreateTrainingComplexRequest(
    val exercises: List<CreateExerciseRequest>,
    val muscularApparatus: Int
)