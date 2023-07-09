package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.model.request.CreateTrainingComplexRequest
import com.example.lizarun.data.storage.model.request.DeleteTrainingComplexRequest
import com.example.lizarun.data.storage.model.request.GetTrainingComplexByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateTrainingComplexRequest
import com.example.lizarun.data.storage.network.LizaRunApiClient
import com.example.lizarun.data.storage.network.rxJavaCompletableCall
import com.example.lizarun.data.storage.network.rxJavaSingleCall

class TrainingComplexRemoteDataSource(context: Context) {
    private val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    fun getAll() = rxJavaSingleCall {
        apiService.getAllTrainingComplexes()
    }

    fun getById(getTrainingComplexByIdRequest: GetTrainingComplexByIdRequest) = rxJavaSingleCall {
        apiService.getTrainingComplexById(id = getTrainingComplexByIdRequest.id)
    }

    fun createNew(createTrainingComplexRequest: CreateTrainingComplexRequest) = rxJavaSingleCall {
        apiService.createTrainingComplex(requestBody = createTrainingComplexRequest)
    }

    fun update(
        trainingComplexId: String,
        updateTrainingComplexRequest: UpdateTrainingComplexRequest
    ) = rxJavaCompletableCall {
        apiService.updateTrainingComplex(
            id = trainingComplexId,
            requestBody = updateTrainingComplexRequest
        )
    }

    fun delete(deleteTrainingComplexRequest: DeleteTrainingComplexRequest) = rxJavaCompletableCall {
        apiService.deleteTrainingComplex(id = deleteTrainingComplexRequest.id)
    }
}