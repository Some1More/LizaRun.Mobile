package com.example.lizarun.data.storage.model.request

data class GetCompetitionResultsByFiltersRequest(
    val competitionId: String,
    val competitionFilters: GetCompetitionsByFiltersRequest,
    val sportsmanId: String,
    val trainerId: String,
    val occupiedPlace: Int
)
