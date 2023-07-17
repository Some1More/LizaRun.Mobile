package com.example.lizarun.domain.model.entity

data class CompetitionInList(
    val id: String,
    val name: String,
    val distance: Int,
    val dateTime: String,
    val trackType: Int,
    val description: String
)
