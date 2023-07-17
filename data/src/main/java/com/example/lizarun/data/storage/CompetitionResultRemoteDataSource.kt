package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.model.request.DeleteCompetitionResultRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultByIdRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultsByCompetitionIdRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultsByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionResultsBySportsmanIdRequest
import com.example.lizarun.data.storage.model.request.UpdateCompetitionResultRequest
import com.example.lizarun.data.storage.network.LizaRunApiClient
import com.example.lizarun.data.storage.network.rxJavaCompletableCall
import com.example.lizarun.data.storage.network.rxJavaSingleCall

class CompetitionResultRemoteDataSource(context: Context) {
    private val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    fun getResultsByCompetitionId(
        getCompetitionResultsByCompetitionIdRequest: GetCompetitionResultsByCompetitionIdRequest
    ) = rxJavaSingleCall {
        apiService.getCompetitionResultsByCompetitionId(
            id = getCompetitionResultsByCompetitionIdRequest.id
        )
    }

    fun getResultsBySportsmanId(
        getCompetitionResultsBySportsmanIdRequest: GetCompetitionResultsBySportsmanIdRequest
    ) = rxJavaSingleCall {
        apiService.getCompetitionResultsBySportsmanId(
            id = getCompetitionResultsBySportsmanIdRequest.id
        )
    }

    fun getResultsByFilters(
        getCompetitionResultsByFiltersRequest: GetCompetitionResultsByFiltersRequest
    ) = rxJavaSingleCall {
        apiService.getCompetitionResultsByFilters(
            requestBody = getCompetitionResultsByFiltersRequest
        )
    }

    fun getResultById(
        getCompetitionResultByIdRequest: GetCompetitionResultByIdRequest
    ) = rxJavaSingleCall {
        apiService.getCompetitionResultById(id = getCompetitionResultByIdRequest.id)
    }

    fun createNewResult() = rxJavaSingleCall {
        apiService.createCompetitionResult()
    }

    fun updateResult(updateCompetitionResultRequest: UpdateCompetitionResultRequest) = rxJavaCompletableCall {
        apiService.updateCompetitionResult(id = updateCompetitionResultRequest.id)
    }

    fun deleteResult(deleteCompetitionResultRequest: DeleteCompetitionResultRequest) = rxJavaCompletableCall {
        apiService.deleteCompetitionResult(id = deleteCompetitionResultRequest.id)
    }
}
