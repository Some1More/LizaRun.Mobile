package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.response.TrainingComplexResponse
import com.example.lizarun.domain.model.entity.TrainingComplex

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