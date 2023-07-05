package com.example.lizarun.data.storage.model.request

data class BirthDateRequest(
    val year: Int,
    val month: Int,
    val day: Int,
    val dayOfWeek: Int,
    val dayOfYear: Int,
    val dayNumber: Int
)