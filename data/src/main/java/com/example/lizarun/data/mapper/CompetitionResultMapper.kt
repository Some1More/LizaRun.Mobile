package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.DeleteCompetitionResultRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultByIdRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultsByCompetitionIdRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultsByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultsBySportsmanIdRequest
import com.example.lizarun.data.storage.model.request.UpdateCompetitionResultRequest
import com.example.lizarun.data.storage.model.response.CompetitionResultInListResponse
import com.example.lizarun.data.storage.model.response.CompetitionResultResponse
import com.example.lizarun.domain.model.entity.CompetitionResult
import com.example.lizarun.domain.model.entity.CompetitionResultInList
import com.example.lizarun.domain.model.param.DeleteCompetitionResultParam
import com.example.lizarun.domain.model.param.GetCompetitionResultByIdParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsByCompetitionIdParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsBySportsmanIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionResultParam

fun List<CompetitionResultInListResponse>.mapToDomain(): List<CompetitionResultInList> {
    return map {
        CompetitionResultInList(
            id = it.id,
            competitionId = it.competitionId,
            competitionName = it.competitionName,
            sportsmanId = it.sportsmanId,
            occupiedPlace = it.occupiedPlace
        )
    }
}

fun CompetitionResultResponse.mapToDomain(): CompetitionResult {
    return CompetitionResult(
        id = id,
        competition = competition.mapToDomain()
    )
}

fun GetCompetitionResultsByCompetitionIdParam.mapToStorage(): GetCompetitionResultsByCompetitionIdRequest {
    return GetCompetitionResultsByCompetitionIdRequest(id = id)
}

fun GetCompetitionResultsBySportsmanIdParam.mapToStorage(): GetCompetitionResultsBySportsmanIdRequest {
    return GetCompetitionResultsBySportsmanIdRequest(id = id)
}

fun GetCompetitionResultsByFiltersParam.mapToStorage(): GetCompetitionResultsByFiltersRequest {
    return GetCompetitionResultsByFiltersRequest(
        competitionId = competitionId,
        competitionFilters = competitionFilters.mapToStorage(),
        sportsmanId = sportsmanId,
        trainerId = trainerId,
        occupiedPlace = occupiedPlace
    )
}

fun GetCompetitionResultByIdParam.mapToStorage(): GetCompetitionResultByIdRequest {
    return GetCompetitionResultByIdRequest(id = id)
}

fun UpdateCompetitionResultParam.mapToStorage(): UpdateCompetitionResultRequest {
    return UpdateCompetitionResultRequest(id = id)
}

fun DeleteCompetitionResultParam.mapToStorage(): DeleteCompetitionResultRequest {
    return DeleteCompetitionResultRequest(id = id)
}