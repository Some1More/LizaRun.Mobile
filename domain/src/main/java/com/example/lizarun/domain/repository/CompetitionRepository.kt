package com.example.lizarun.domain.repository

import com.example.lizarun.domain.model.entity.Competition
import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.model.param.CreateCompetitionParam
import com.example.lizarun.domain.model.param.DeleteCompetitionParam
import com.example.lizarun.domain.model.param.GetCompetitionsByFiltersParam
import com.example.lizarun.domain.model.param.GetCompetitionByIdParam
import com.example.lizarun.domain.model.param.UpdateCompetitionParam
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CompetitionRepository {
    fun getAllCompetitions(): Single<List<CompetitionInList>>

    fun getCompetitionsByFilters(param: GetCompetitionsByFiltersParam): Single<List<CompetitionInList>>

    fun getCompetitionById(param: GetCompetitionByIdParam): Single<Competition>

    fun createCompetition(param: CreateCompetitionParam): Single<Competition>

    fun updateCompetition(param: UpdateCompetitionParam): Completable

    fun deleteCompetition(param: DeleteCompetitionParam): Completable
}