package com.example.lizarun.data.repository

import com.example.lizarun.data.mapper.mapToDomain
import com.example.lizarun.data.mapper.mapToStorage
import com.example.lizarun.data.storage.CompetitionResultRemoteDataSource
import com.example.lizarun.domain.model.entity.CompetitionResult
import com.example.lizarun.domain.model.entity.CompetitionResultInList
import com.example.lizarun.domain.model.param.DeleteCompetitionResultParam
import com.example.lizarun.domain.model.param.GetCompetitionResultByIdParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsByCompetitionIdParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsBySportsmanIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionResultParam
import com.example.lizarun.domain.repository.CompetitionResultRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CompetitionResultRepositoryImpl(
    private val competitionResultRemoteDataSource: CompetitionResultRemoteDataSource
) : CompetitionResultRepository {
    override fun getCompetitionResultsByCompetitionId(
        param: GetCompetitionResultsByCompetitionIdParam
    ): Single<List<CompetitionResultInList>> {
        val request = param.mapToStorage()
        return competitionResultRemoteDataSource.getResultsByCompetitionId(
            getCompetitionResultsByCompetitionIdRequest = request
        ).map {
            it.mapToDomain()
        }
    }

    override fun getCompetitionResultsBySportsmanId(
        param: GetCompetitionResultsBySportsmanIdParam
    ): Single<List<CompetitionResultInList>> {
        val request = param.mapToStorage()
        return competitionResultRemoteDataSource.getResultsBySportsmanId(
            getCompetitionResultsBySportsmanIdRequest = request
        ).map {
            it.mapToDomain()
        }
    }

    override fun getCompetitionResultsByFilters(param: GetCompetitionResultsByFiltersParam): Single<List<CompetitionResultInList>> {
        val request = param.mapToStorage()
        return competitionResultRemoteDataSource.getResultsByFilters(
            getCompetitionResultsByFiltersRequest = request
        ).map {
            it.mapToDomain()
        }
    }

    override fun getCompetitionResultById(param: GetCompetitionResultByIdParam): Single<CompetitionResult> {
        val request = param.mapToStorage()
        return competitionResultRemoteDataSource.getResultById(
            getCompetitionResultByIdRequest = request
        ).map {
            it.mapToDomain()
        }
    }

    override fun createCompetitionResult(): Single<CompetitionResult> {
        return competitionResultRemoteDataSource.createNewResult().map {
            it.mapToDomain()
        }
    }

    override fun updateCompetitionResult(param: UpdateCompetitionResultParam): Completable {
        val request = param.mapToStorage()
        return competitionResultRemoteDataSource.updateResult(
            updateCompetitionResultRequest = request
        )
    }

    override fun deleteCompetitionResult(param: DeleteCompetitionResultParam): Completable {
        val request = param.mapToStorage()
        return competitionResultRemoteDataSource.deleteResult(
            deleteCompetitionResultRequest = request
        )
    }
}