package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.CreateCompetitionRequest
import com.example.lizarun.data.storage.model.request.DeleteCompetitionRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateCompetitionRequest
import com.example.lizarun.data.storage.model.response.CompetitionInListResponse
import com.example.lizarun.data.storage.model.response.CompetitionResponse
import com.example.lizarun.domain.model.entity.Competition
import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.model.param.CreateCompetitionParam
import com.example.lizarun.domain.model.param.DeleteCompetitionParam
import com.example.lizarun.domain.model.param.GetCompetitionByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionByIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionParam

fun List<CompetitionInListResponse>.mapToDomain(): List<CompetitionInList> {
    return map {
        CompetitionInList(
            id = it.id,
            name = it.name,
            distance = it.distance,
            dateTime = it.dateTime,
            trackType = it.trackType,
            description = it.description
        )
    }
}

fun CompetitionResponse.mapToDomain(): Competition {
    return Competition(
        name = name,
        distance = distance,
        dateTime = dateTime,
        trackType = trackType,
        description = description,
        addressId = addressId,
        address = address.mapToDomain(),
        registrationLink = registrationLink,
        id = id
    )
}

fun GetCompetitionByFiltersParam.mapToStorage(): GetCompetitionByFiltersRequest {
    return GetCompetitionByFiltersRequest(
        distance = distance,
        dateTime = dateTime,
        trackType = trackType,
        address = address.mapToStorage()
    )
}

fun GetCompetitionByIdParam.mapToStorage(): GetCompetitionByIdRequest {
    return GetCompetitionByIdRequest(id = id)
}

fun CreateCompetitionParam.mapToStorage(): CreateCompetitionRequest {
    return CreateCompetitionRequest(
        name = name,
        distance = distance,
        dateTime = dateTime,
        trackType = trackType,
        description = description,
        addressId = addressId,
        address = address.mapToStorage(),
        registrationLink = registrationLink
    )
}

fun UpdateCompetitionParam.mapToStorage(): UpdateCompetitionRequest {
    return UpdateCompetitionRequest(
        name = name,
        distance = distance,
        dateTime = dateTime,
        trackType = trackType,
        description = description,
        addressId = addressId,
        address = address.mapToStorage(),
        registrationLink = registrationLink
    )
}

fun DeleteCompetitionParam.mapToStorage(): DeleteCompetitionRequest {
    return DeleteCompetitionRequest(id = id)
}

























