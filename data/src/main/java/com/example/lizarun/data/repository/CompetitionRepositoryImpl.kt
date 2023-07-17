package com.example.lizarun.data.repository

import com.example.lizarun.data.mapper.mapToDomain
import com.example.lizarun.data.mapper.mapToStorage
import com.example.lizarun.data.storage.CompetitionRemoteDataSource
import com.example.lizarun.domain.model.entity.Competition
import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.model.param.CreateCompetitionParam
import com.example.lizarun.domain.model.param.DeleteCompetitionParam
import com.example.lizarun.domain.model.param.GetCompetitionByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionByIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionParam
import com.example.lizarun.domain.repository.CompetitionRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CompetitionRepositoryImpl(private val competitionRemoteDataSource: CompetitionRemoteDataSource) : CompetitionRepository {
    override fun getAllCompetitions(): Single<List<CompetitionInList>> {
        return competitionRemoteDataSource.getAll().map {
            it.mapToDomain()
        }
    }

    override fun getCompetitionByFilters(param: GetCompetitionByFiltersParam): Single<List<CompetitionInList>> {
        val request = param.mapToStorage()
        return competitionRemoteDataSource.getByFilters(getCompetitionByFiltersRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun getCompetitionById(param: GetCompetitionByIdParam): Single<Competition> {
        val request = param.mapToStorage()
        return competitionRemoteDataSource.getById(getCompetitionByIdRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun createCompetition(param: CreateCompetitionParam): Single<Competition> {
        val request = param.mapToStorage()
        return competitionRemoteDataSource.createNew(createCompetitionRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun updateCompetition(param: UpdateCompetitionParam): Completable {
        val request = param.mapToStorage()
        return competitionRemoteDataSource.update(
            competitionId = param.id,
            updateCompetitionRequest = request
        )
    }

    override fun deleteCompetition(param: DeleteCompetitionParam): Completable {
        val request = param.mapToStorage()
        return competitionRemoteDataSource.delete(deleteCompetitionRequest = request)
    }
}