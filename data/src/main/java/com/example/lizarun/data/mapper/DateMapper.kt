package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.BirthDateRequest
import com.example.lizarun.data.storage.model.response.DateResponse
import com.example.lizarun.domain.model.entity.BirthDate

fun DateResponse.mapToDomain(): BirthDate {
    return BirthDate(
        year = year,
        month = month,
        day = day,
        dayOfWeek = dayOfWeek,
        dayOfYear = dayOfYear,
        dayNumber = dayNumber
    )
}

fun BirthDate.mapToStorage(): BirthDateRequest {
    return BirthDateRequest(
        year = year,
        month = month,
        day = day,
        dayOfWeek = dayOfWeek,
        dayOfYear = dayOfYear,
        dayNumber = dayNumber
    )
}