package com.example.lizarun.data.storage.model.request

data class GetCompetitionByFiltersRequest(
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val address: AddressRequest
)
