package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.WorkoutExerciseRequest
import com.example.lizarun.data.storage.model.response.WorkoutExerciseResponse
import com.example.lizarun.domain.model.entity.WorkoutExercise
import com.example.lizarun.domain.model.param.CreateWorkoutExerciseParam

fun List<WorkoutExerciseResponse>.mapToDomain(): List<WorkoutExercise> {
    return map {
        WorkoutExercise(
            id = it.id,
            repetitionsCount = it.repetitionsCount,
            approachesCount = it.approachesCount,
            leadTime = it.leadTime.mapToDomain(),
            distance = it.distance,
            pace = it.pace.mapToDomain(),
            restTime = it.restTime.mapToDomain(),
            exercise = it.exercise.mapToDomain(),
            exercises = it.exercises.mapToDomain()
        )
    }
}

fun List<CreateWorkoutExerciseParam>.mapToStorage(): List<WorkoutExerciseRequest> {
    return map {
        WorkoutExerciseRequest(
            repetitionsCount = it.repetitionsCount,
            approachesCount = it.approachesCount,
            leadTime = it.leadTime.mapToStorage(),
            distance = it.distance,
            pace = it.pace.mapToStorage(),
            restTime = it.restTime.mapToStorage(),
            exerciseId = it.exerciseId,
            exerciseIds = it.exerciseIds
        )
    }
}