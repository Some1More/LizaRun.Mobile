package com.example.lizarun.domain.model.param

data class UpdateCompetitionParam(
    val id: String,
    val name: String,
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val description: String,
    val addressId: String,
    val address: CreateAddressParam,
    val registrationLink: String
)
