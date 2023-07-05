package com.example.lizarun.data.storage.model.request

data class GetExercisesByFiltersRequest(
    val exerciseType: Int,
    val muscularApparatus: Int
)
