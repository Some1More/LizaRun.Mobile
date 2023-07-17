package com.example.lizarun.data.storage.model.response

data class CompetitionResponse(
    val name: String,
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val description: String,
    val addressId: String,
    val address: AddressResponse,
    val registrationLink: String,
    val id: String
)
