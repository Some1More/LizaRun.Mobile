package com.example.lizarun.data.storage.model.response

data class CompetitionResultInListResponse(
    val id: String,
    val competitionId: String,
    val competitionName: String,
    val sportsmanId: String,
    val occupiedPlace: Int
)
