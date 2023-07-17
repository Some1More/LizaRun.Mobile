package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.CreateCompetitionRequest
import com.example.lizarun.data.storage.model.request.DeleteCompetitionRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionsByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateCompetitionRequest
import com.example.lizarun.data.storage.model.response.CompetitionInListResponse
import com.example.lizarun.data.storage.model.response.CompetitionResponse
import com.example.lizarun.domain.model.entity.Competition
import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.model.param.CreateCompetitionParam
import com.example.lizarun.domain.model.param.DeleteCompetitionParam
import com.example.lizarun.domain.model.param.GetCompetitionsByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionByIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionParam

fun List<CompetitionInListResponse>.mapToDomain(): List<CompetitionInList> {
    return map {
        it.mapToDomain()
    }
}

fun CompetitionInListResponse.mapToDomain(): CompetitionInList {
    return CompetitionInList(
        id = id,
        name = name,
        distance = distance,
        dateTime = dateTime,
        trackType = trackType,
        description = description
    )
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

fun GetCompetitionsByFiltersParam.mapToStorage(): GetCompetitionsByFiltersRequest {
    return GetCompetitionsByFiltersRequest(
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

























