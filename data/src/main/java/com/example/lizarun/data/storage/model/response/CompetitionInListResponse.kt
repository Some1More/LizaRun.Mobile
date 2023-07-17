package com.example.lizarun.data.storage.model.response

data class CompetitionInListResponse(
    val id: String,
    val name: String,
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val description: String
)
