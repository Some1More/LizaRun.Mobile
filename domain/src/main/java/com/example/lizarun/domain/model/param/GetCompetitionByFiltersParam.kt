package com.example.lizarun.domain.model.param

data class GetCompetitionByFiltersParam(
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val address: CreateAddressParam
)
