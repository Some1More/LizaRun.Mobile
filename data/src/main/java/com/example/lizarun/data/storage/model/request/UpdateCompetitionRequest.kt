package com.example.lizarun.data.storage.model.request

data class UpdateCompetitionRequest(
    val name: String,
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val description: String,
    val addressId: String,
    val address: AddressRequest,
    val registrationLink: String
)
