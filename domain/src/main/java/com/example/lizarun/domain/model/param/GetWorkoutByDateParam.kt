package com.example.lizarun.domain.model.param

data class GetWorkoutByDateParam(
    val year: Int,
    val month: Int,
    val day: Int,
    val dayOfWeek: Int
)
