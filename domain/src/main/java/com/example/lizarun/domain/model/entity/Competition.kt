package com.example.lizarun.domain.model.entity

data class Competition(
    val name: String,
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val description: String,
    val addressId: String,
    val address: Address,
    val registrationLink: String,
    val id: String
)
