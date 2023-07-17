package com.example.lizarun.domain.model.entity

data class CompetitionResultInList(
    val id: String,
    val competitionId: String,
    val competitionName: String,
    val sportsmanId: String,
    val occupiedPlace: Int
)
