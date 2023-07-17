package com.example.lizarun.domain.model.param

data class GetCompetitionResultsByFiltersParam(
    val competitionId: String,
    val competitionFilters: GetCompetitionsByFiltersParam,
    val sportsmanId: String,
    val trainerId: String,
    val occupiedPlace: Int
)
