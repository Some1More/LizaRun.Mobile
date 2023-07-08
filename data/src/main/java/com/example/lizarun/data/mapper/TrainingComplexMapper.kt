package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.CreateTrainingComplexRequest
import com.example.lizarun.data.storage.model.request.DeleteTrainingComplexRequest
import com.example.lizarun.data.storage.model.request.GetTrainingComplexByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateTrainingComplexRequest
import com.example.lizarun.data.storage.model.response.TrainingComplexResponse
import com.example.lizarun.domain.model.entity.TrainingComplex
import com.example.lizarun.domain.model.param.CreateTrainingComplexParam
import com.example.lizarun.domain.model.param.DeleteTrainingComplexParam
import com.example.lizarun.domain.model.param.GetTrainingComplexByIdParam
import com.example.lizarun.domain.model.param.UpdateTrainingComplexParam

fun TrainingComplexResponse.mapToDomain(): TrainingComplex {
    return TrainingComplex(
        exercises = exercises.mapToDomain(),
        muscularApparatus = muscularApparatus,
        authorId = authorId,
        author = author.mapToDomain()
    )
}

fun List<TrainingComplexResponse>.mapToDomain(): List<TrainingComplex> {
    return map {
        it.mapToDomain()
    }
}

fun GetTrainingComplexByIdParam.mapToStorage(): GetTrainingComplexByIdRequest {
    return GetTrainingComplexByIdRequest(id = id)
}

fun CreateTrainingComplexParam.mapToStorage(): CreateTrainingComplexRequest {
    return CreateTrainingComplexRequest(
        exercises = exercises.mapToStorage(),
        muscularApparatus = muscularApparatus
    )
}

fun UpdateTrainingComplexParam.mapToStorage(): UpdateTrainingComplexRequest {
    return UpdateTrainingComplexRequest(
        exercises = exercises.mapToStorage(),
        muscularApparatus = muscularApparatus
    )
}

fun DeleteTrainingComplexParam.mapToStorage(): DeleteTrainingComplexRequest {
    return DeleteTrainingComplexRequest(id = id)
}