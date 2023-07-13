package com.example.lizarun.data.storage.model.request

data class GetWorkoutByDateRequest(
    val year: Int,
    val month: Int,
    val day: Int,
    val dayOfWeek: Int
)
