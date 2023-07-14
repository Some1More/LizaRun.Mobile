package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.TimeRequest
import com.example.lizarun.data.storage.model.response.TimeResponse
import com.example.lizarun.domain.model.entity.Time
import com.example.lizarun.domain.model.param.CreateTimeParam

fun TimeResponse.mapToDomain(): Time {
    return Time(
        hour = hour,
        minute = minute,
        second = second,
        millisecond = millisecond,
        ticks = ticks
    )
}

fun CreateTimeParam.mapToStorage(): TimeRequest {
    return TimeRequest(
        hour = hour,
        minute = minute,
        second = second,
        millisecond = millisecond,
        ticks = ticks
    )
}