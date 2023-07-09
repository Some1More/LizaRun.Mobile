package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.model.request.CreateExerciseRequest
import com.example.lizarun.data.storage.model.request.DeleteExerciseRequest
import com.example.lizarun.data.storage.model.request.GetExerciseByIdRequest
import com.example.lizarun.data.storage.model.request.GetExerciseByNameRequest
import com.example.lizarun.data.storage.model.request.GetExercisesByFiltersRequest
import com.example.lizarun.data.storage.model.request.UpdateExerciseRequest
import com.example.lizarun.data.storage.network.LizaRunApiClient
import com.example.lizarun.data.storage.network.rxJavaCompletableCall
import com.example.lizarun.data.storage.network.rxJavaSingleCall

class ExerciseRemoteDataSource(context: Context) {
    private val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    fun getAll() = rxJavaSingleCall {
        apiService.getAllExercises()
    }

    fun getByFilters(getExercisesByFiltersRequest: GetExercisesByFiltersRequest) = rxJavaSingleCall {
        apiService.getExercisesByFilters(requestBody = getExercisesByFiltersRequest)
    }

    fun getById(getExerciseByIdRequest: GetExerciseByIdRequest) = rxJavaSingleCall {
        apiService.getExerciseById(id = getExerciseByIdRequest.id)
    }

    fun getByName(getExerciseByNameRequest: GetExerciseByNameRequest) = rxJavaSingleCall {
        apiService.getExerciseByName(name = getExerciseByNameRequest.name)
    }

    fun createNew(createExerciseRequest: CreateExerciseRequest) = rxJavaSingleCall {
        apiService.createExercise(requestBody = createExerciseRequest)
    }

    fun update(
        exerciseId: String,
        updateExerciseRequest: UpdateExerciseRequest
    ) = rxJavaCompletableCall {
        apiService.updateExercise(id = exerciseId, requestBody = updateExerciseRequest)
    }

    fun delete(deleteExerciseRequest: DeleteExerciseRequest) = rxJavaCompletableCall {
        apiService.deleteExercise(id = deleteExerciseRequest.id)
    }
}