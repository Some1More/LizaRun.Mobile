package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.ChangeWorkoutExecutionStatusRequest
import com.example.lizarun.data.storage.model.request.CreateWorkoutRequest
import com.example.lizarun.data.storage.model.request.DeleteWorkoutRequest
import com.example.lizarun.data.storage.model.request.GetWorkoutByDateRequest
import com.example.lizarun.data.storage.model.request.GetWorkoutByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateWorkoutForSportsmanRequest
import com.example.lizarun.data.storage.model.request.UpdateWorkoutForTrainerRequest
import com.example.lizarun.data.storage.model.request.WriteCommentsToWorkoutRequest
import com.example.lizarun.data.storage.model.request.WriteRecommendationsToWorkoutRequest
import com.example.lizarun.data.storage.model.response.WorkoutInListResponse
import com.example.lizarun.data.storage.model.response.WorkoutResponse
import com.example.lizarun.domain.model.entity.Workout
import com.example.lizarun.domain.model.entity.WorkoutInList
import com.example.lizarun.domain.model.param.ChangeWorkoutExecutionStatusParam
import com.example.lizarun.domain.model.param.CreateWorkoutParam
import com.example.lizarun.domain.model.param.DeleteWorkoutParam
import com.example.lizarun.domain.model.param.GetWorkoutByDateParam
import com.example.lizarun.domain.model.param.GetWorkoutByIdParam
import com.example.lizarun.domain.model.param.UpdateWorkoutForSportsmanParam
import com.example.lizarun.domain.model.param.UpdateWorkoutForTrainerParam
import com.example.lizarun.domain.model.param.WriteCommentsToWorkoutParam
import com.example.lizarun.domain.model.param.WriteRecommendationsToWorkoutParam


fun List<WorkoutInListResponse>.mapToDomain(): List<WorkoutInList> {
    return map {
        it.mapToDomain()
    }
}

fun WorkoutResponse.mapToDomain(): Workout {
    return Workout(
        id = id,
        name = name,
        sportsmanId = sportsmanId,
        date = date.mapToDomain(),
        workoutType = workoutType,
        restTime = restTime.mapToDomain(),
        isWithTrainer = isWithTrainer,
        trainerRecommendations = trainerRecommendations,
        workoutExercises = workoutExercises.mapToDomain(),
        sportsmanComments = sportsmanComments,
        executionStatus = executionStatus
    )
}

fun WorkoutInListResponse.mapToDomain(): WorkoutInList {
    return WorkoutInList(
        id = id,
        name = name,
        date = date.mapToDomain(),
        sportsmanId = sportsmanId,
        workoutType = workoutType,
        executionStatus = executionStatus
    )
}

fun GetWorkoutByDateParam.mapToStorage(): GetWorkoutByDateRequest {
    return GetWorkoutByDateRequest(
        year = year,
        month = month,
        day = day,
        dayOfWeek = dayOfWeek
    )
}

fun GetWorkoutByIdParam.mapToStorage(): GetWorkoutByIdRequest {
    return GetWorkoutByIdRequest(id = id)
}

fun CreateWorkoutParam.mapToStorage(): CreateWorkoutRequest {
    return CreateWorkoutRequest(
        name = name,
        sportsmanId = sportsmanId,
        date = date.mapToStorage(),
        workoutType = workoutType,
        restTime = restTime.mapToStorage(),
        isWithTrainer = isWithTrainer,
        trainerRecommendations = trainerRecommendations,
        workoutExercises = workoutExercises.mapToStorage()
    )
}

fun WriteCommentsToWorkoutParam.mapToStorage(): WriteCommentsToWorkoutRequest {
    return WriteCommentsToWorkoutRequest(
        id = id,
        comments = comments
    )
}

fun WriteRecommendationsToWorkoutParam.mapToStorage(): WriteRecommendationsToWorkoutRequest {
    return WriteRecommendationsToWorkoutRequest(
        id = id,
        recommendations = recommendations
    )
}

fun UpdateWorkoutForTrainerParam.mapToStorage(): UpdateWorkoutForTrainerRequest {
    return UpdateWorkoutForTrainerRequest(
        name = name,
        sportsmanId = sportsmanId,
        date = date.mapToStorage(),
        workoutType = workoutType,
        workoutExercises = workoutExercises.mapToStorage(),
        restTime = restTime.mapToStorage(),
        isWithTrainer = isWithTrainer,
        trainerRecommendations = trainerRecommendations
    )
}

fun UpdateWorkoutForSportsmanParam.mapToStorage(): UpdateWorkoutForSportsmanRequest {
    return UpdateWorkoutForSportsmanRequest(
        workoutExercises = workoutExercises.mapToStorage(),
        restTime = restTime.mapToStorage(),
        sportsmanComments = sportsmanComments
    )
}

fun ChangeWorkoutExecutionStatusParam.mapToStorage(): ChangeWorkoutExecutionStatusRequest {
    return ChangeWorkoutExecutionStatusRequest(
        id = id,
        executeStatus = executeStatus
    )
}

fun DeleteWorkoutParam.mapToStorage(): DeleteWorkoutRequest {
    return DeleteWorkoutRequest(id = id)
}