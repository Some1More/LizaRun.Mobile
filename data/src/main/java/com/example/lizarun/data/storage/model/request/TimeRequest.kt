package com.example.lizarun.data.storage.model.request

data class TimeRequest(
    val hour: Int,
    val minute: Int,
    val second: Int,
    val millisecond: Int,
    val ticks: Int
)
