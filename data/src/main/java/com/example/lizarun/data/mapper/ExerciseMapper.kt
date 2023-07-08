package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.CreateExerciseRequest
import com.example.lizarun.data.storage.model.request.DeleteExerciseRequest
import com.example.lizarun.data.storage.model.request.GetExerciseByIdRequest
import com.example.lizarun.data.storage.model.request.GetExerciseByNameRequest
import com.example.lizarun.data.storage.model.request.GetExercisesByFiltersRequest
import com.example.lizarun.data.storage.model.request.UpdateExerciseRequest
import com.example.lizarun.data.storage.model.response.ExerciseInListResponse
import com.example.lizarun.data.storage.model.response.ExerciseResponse
import com.example.lizarun.domain.model.entity.Exercise
import com.example.lizarun.domain.model.entity.ExerciseInList
import com.example.lizarun.domain.model.param.CreateExerciseParam
import com.example.lizarun.domain.model.param.DeleteExerciseParam
import com.example.lizarun.domain.model.param.GetExerciseByIdParam
import com.example.lizarun.domain.model.param.GetExerciseByNameParam
import com.example.lizarun.domain.model.param.GetExercisesByFiltersParam
import com.example.lizarun.domain.model.param.UpdateExerciseParam

fun ExerciseResponse.mapToDomain(): Exercise {
    return Exercise(
        name = name,
        description = description,
        recommendations = recommendations,
        exerciseType = exerciseType,
        muscularApparatus = muscularApparatus,
        photo = photo,
        video = video,
        id = id
    )
}

fun List<ExerciseInListResponse>.mapToDomain(): List<ExerciseInList> {
    return map {
        ExerciseInList(
            id = it.id,
            name = it.name,
            exerciseType = it.exerciseType,
            muscularApparatus = it.muscularApparatus,
            photo = it.photo
        )
    }
}

fun List<CreateExerciseParam>.mapToStorage(): List<CreateExerciseRequest> {
    return map {
        CreateExerciseRequest(
            name = it.name,
            description = it.description,
            recommendations = it.recommendations,
            exerciseType = it.exerciseType,
            muscularApparatus = it.muscularApparatus,
            photo = it.photo,
            video = it.video
        )
    }
}

fun GetExercisesByFiltersParam.mapToStorage(): GetExercisesByFiltersRequest {
    return GetExercisesByFiltersRequest(
        exerciseType = exerciseType,
        muscularApparatus = muscularApparatus
    )
}

fun GetExerciseByIdParam.mapToStorage(): GetExerciseByIdRequest {
    return GetExerciseByIdRequest(id = id)
}

fun GetExerciseByNameParam.mapToStorage(): GetExerciseByNameRequest {
    return GetExerciseByNameRequest(name = name)
}

fun CreateExerciseParam.mapToStorage(): CreateExerciseRequest {
    return CreateExerciseRequest(
        name = name,
        description = description,
        recommendations = recommendations,
        exerciseType = exerciseType,
        muscularApparatus = muscularApparatus,
        photo = photo,
        video = video
    )
}

fun UpdateExerciseParam.mapToStorage(): UpdateExerciseRequest {
    return UpdateExerciseRequest(
        name = name,
        description = description,
        recommendations = recommendations,
        exerciseType = exerciseType,
        muscularApparatus = muscularApparatus,
        photo = photo,
        video = video
    )
}

fun DeleteExerciseParam.mapToStorage(): DeleteExerciseRequest {
    return DeleteExerciseRequest(id = id)
}