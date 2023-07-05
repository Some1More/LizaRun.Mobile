package com.example.lizarun.data.storage.model.request

data class UpdateTrainingComplexRequest(
    val exercises: List<ExerciseRequest>,
    val muscularApparatus: Int
)