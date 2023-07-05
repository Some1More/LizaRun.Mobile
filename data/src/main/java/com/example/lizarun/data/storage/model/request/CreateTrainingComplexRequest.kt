package com.example.lizarun.data.storage.model.request

data class CreateTrainingComplexRequest(
    val exercises: List<ExerciseRequest>,
    val muscularApparatus: Int
)