package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.base.BaseRemoteDataSource
import com.example.lizarun.data.storage.model.request.CreateExerciseRequest
import com.example.lizarun.data.storage.model.request.DeleteExerciseRequest
import com.example.lizarun.data.storage.model.request.GetExerciseByIdRequest
import com.example.lizarun.data.storage.model.request.GetExerciseByNameRequest
import com.example.lizarun.data.storage.model.request.GetExercisesByFiltersRequest
import com.example.lizarun.data.storage.model.request.UpdateExerciseRequest

class ExerciseRemoteDataSource(context: Context) : BaseRemoteDataSource(context) {
    suspend fun getAll() = apiRequestFlow {
        apiService.getAllExercises()
    }

    suspend fun getByFilters(getExercisesByFiltersRequest: GetExercisesByFiltersRequest) = apiRequestFlow {
        apiService.getExercisesByFilters(requestBody = getExercisesByFiltersRequest)
    }

    suspend fun getById(getExerciseByIdRequest: GetExerciseByIdRequest) = apiRequestFlow {
        apiService.getExerciseById(id = getExerciseByIdRequest.id)
    }

    suspend fun getByName(getExerciseByNameRequest: GetExerciseByNameRequest) = apiRequestFlow {
        apiService.getExerciseByName(name = getExerciseByNameRequest.name)
    }

    suspend fun createNew(createExerciseRequest: CreateExerciseRequest) = apiRequestFlow {
        apiService.createExercise(requestBody = createExerciseRequest)
    }

    suspend fun update(
        exerciseId: String,
        updateExerciseRequest: UpdateExerciseRequest
    ) = apiRequestFlow {
        apiService.updateExercise(id = exerciseId, requestBody = updateExerciseRequest)
    }

    suspend fun delete(deleteExerciseRequest: DeleteExerciseRequest) = apiRequestFlow {
        apiService.deleteExercise(id = deleteExerciseRequest.id)
    }
}