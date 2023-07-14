package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.model.request.ChangeWorkoutExecutionStatusRequest
import com.example.lizarun.data.storage.model.request.CreateWorkoutRequest
import com.example.lizarun.data.storage.model.request.DeleteWorkoutRequest
import com.example.lizarun.data.storage.model.request.GetWorkoutByDateRequest
import com.example.lizarun.data.storage.model.request.GetWorkoutByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateWorkoutForSportsmanRequest
import com.example.lizarun.data.storage.model.request.UpdateWorkoutForTrainerRequest
import com.example.lizarun.data.storage.model.request.WriteCommentsToWorkoutRequest
import com.example.lizarun.data.storage.model.request.WriteRecommendationsToWorkoutRequest
import com.example.lizarun.data.storage.network.LizaRunApiClient
import com.example.lizarun.data.storage.network.rxJavaCompletableCall
import com.example.lizarun.data.storage.network.rxJavaSingleCall

class WorkoutRemoteDataSource(context: Context) {
    private val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    fun getByDate(getWorkoutByDateRequest: GetWorkoutByDateRequest) = rxJavaSingleCall {
        apiService.getWorkoutByDate(requestBody = getWorkoutByDateRequest)
    }

    fun getById(getWorkoutByIdRequest: GetWorkoutByIdRequest) = rxJavaSingleCall {
        apiService.getWorkoutById(id = getWorkoutByIdRequest.id)
    }

    fun createNew(createWorkoutRequest: CreateWorkoutRequest) = rxJavaSingleCall {
        apiService.createWorkout(requestBody = createWorkoutRequest)
    }

    fun writeComments(
        writeCommentsToWorkoutRequest: WriteCommentsToWorkoutRequest
    ) = rxJavaCompletableCall {
        apiService.writeCommentsToWorkout(
            id = writeCommentsToWorkoutRequest.id,
            comments = writeCommentsToWorkoutRequest.comments
        )
    }

    fun writeRecommendations(
        writeRecommendationsToWorkoutRequest: WriteRecommendationsToWorkoutRequest
    ) = rxJavaCompletableCall {
        apiService.writeRecommendationsToWorkout(
            id = writeRecommendationsToWorkoutRequest.id,
            recommendations = writeRecommendationsToWorkoutRequest.recommendations
        )
    }

    fun updateForTrainer(
        workoutId: String,
        updateWorkoutForTrainerRequest: UpdateWorkoutForTrainerRequest
    ) = rxJavaCompletableCall {
        apiService.updateWorkoutForTrainer(
            id = workoutId,
            requestBody = updateWorkoutForTrainerRequest
        )
    }

    fun updateForSportsman(
        workoutId: String,
        updateWorkoutForSportsmanRequest: UpdateWorkoutForSportsmanRequest
    ) = rxJavaCompletableCall {
        apiService.updateWorkoutForSportsman(
            id = workoutId,
            requestBody = updateWorkoutForSportsmanRequest
        )
    }

    fun changeExecutionStatus(
        changeWorkoutExecutionStatusRequest: ChangeWorkoutExecutionStatusRequest
    ) = rxJavaCompletableCall {
        apiService.changeWorkoutExecutionStatus(
            id = changeWorkoutExecutionStatusRequest.id,
            executeStatus = changeWorkoutExecutionStatusRequest.executeStatus
        )
    }

    fun delete(deleteWorkoutRequest: DeleteWorkoutRequest) = rxJavaCompletableCall {
        apiService.deleteWorkout(id = deleteWorkoutRequest.id)
    }
}