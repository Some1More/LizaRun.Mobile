package com.example.lizarun.domain.repository

import com.example.lizarun.domain.model.entity.CompetitionResult
import com.example.lizarun.domain.model.entity.CompetitionResultInList
import com.example.lizarun.domain.model.param.DeleteCompetitionResultParam
import com.example.lizarun.domain.model.param.GetCompetitionResultByIdParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsByCompetitionIdParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionResultsBySportsmanIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionResultParam
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CompetitionResultRepository {
    fun getCompetitionResultsByCompetitionId(param: GetCompetitionResultsByCompetitionIdParam): Single<List<CompetitionResultInList>>

    fun getCompetitionResultsBySportsmanId(param: GetCompetitionResultsBySportsmanIdParam): Single<List<CompetitionResultInList>>

    fun getCompetitionResultsByFilters(param: GetCompetitionResultsByFiltersParam): Single<List<CompetitionResultInList>>

    fun getCompetitionResultById(param: GetCompetitionResultByIdParam): Single<CompetitionResult>

    fun createCompetitionResult(): Single<CompetitionResult>

    fun updateCompetitionResult(param: UpdateCompetitionResultParam): Completable

    fun deleteCompetitionResult(param: DeleteCompetitionResultParam): Completable
}