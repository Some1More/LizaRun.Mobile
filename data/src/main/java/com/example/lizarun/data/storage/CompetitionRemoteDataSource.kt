package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.model.request.CreateCompetitionRequest
import com.example.lizarun.data.storage.model.request.DeleteCompetitionRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionByIdRequest
import com.example.lizarun.data.storage.model.request.UpdateCompetitionRequest
import com.example.lizarun.data.storage.network.LizaRunApiClient
import com.example.lizarun.data.storage.network.rxJavaCompletableCall
import com.example.lizarun.data.storage.network.rxJavaSingleCall

class CompetitionRemoteDataSource(context: Context) {
    private val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    fun getAll() = rxJavaSingleCall {
        apiService.getAllCompetitions()
    }

    fun getByFilters(getCompetitionByFiltersRequest: GetCompetitionByFiltersRequest) = rxJavaSingleCall {
        apiService.getCompetitionByFilters(requestBody = getCompetitionByFiltersRequest)
    }

    fun getById(getCompetitionByIdRequest: GetCompetitionByIdRequest) = rxJavaSingleCall {
        apiService.getCompetitionById(id = getCompetitionByIdRequest.id)
    }

    fun createNew(createCompetitionRequest: CreateCompetitionRequest) = rxJavaSingleCall {
        apiService.createCompetition(requestBody = createCompetitionRequest)
    }

    fun update(
        competitionId: String,
        updateCompetitionRequest: UpdateCompetitionRequest
    ) = rxJavaCompletableCall {
        apiService.updateCompetition(id = competitionId, requestBody = updateCompetitionRequest)
    }

    fun delete(deleteCompetitionRequest: DeleteCompetitionRequest) = rxJavaCompletableCall {
        apiService.deleteCompetition(id = deleteCompetitionRequest.id)
    }
}
