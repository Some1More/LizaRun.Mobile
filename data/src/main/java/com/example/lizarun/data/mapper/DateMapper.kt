package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.BirthDateRequest
import com.example.lizarun.data.storage.model.request.DateRequest
import com.example.lizarun.data.storage.model.response.DateResponse
import com.example.lizarun.domain.model.entity.Date
import com.example.lizarun.domain.model.param.CreateDateParam

fun DateResponse.mapToDomain(): Date {
    return Date(
        year = year,
        month = month,
        day = day,
        dayOfWeek = dayOfWeek,
        dayOfYear = dayOfYear,
        dayNumber = dayNumber
    )
}

fun Date.mapToStorage(): BirthDateRequest {
    return BirthDateRequest(
        year = year,
        month = month,
        day = day,
        dayOfWeek = dayOfWeek,
        dayOfYear = dayOfYear,
        dayNumber = dayNumber
    )
}

fun CreateDateParam.mapToStorage(): DateRequest {
    return DateRequest(
        year = year,
        month = month,
        day = day,
        dayOfWeek = dayOfWeek
    )
}