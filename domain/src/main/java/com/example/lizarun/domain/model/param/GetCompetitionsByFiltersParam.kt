package com.example.lizarun.domain.model.param

data class GetCompetitionsByFiltersParam(
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val address: CreateAddressParam
)
