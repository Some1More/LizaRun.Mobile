package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionResultInList
import com.example.lizarun.domain.model.param.GetCompetitionResultsByFiltersParam
import com.example.lizarun.domain.repository.CompetitionResultRepository

class GetCompetitionResultsByFiltersUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<List<CompetitionResultInList>>() {
    operator fun invoke(getCompetitionResultsByFiltersParam: GetCompetitionResultsByFiltersParam) =
        competitionResultRepository.getCompetitionResultsByFilters(
            param = getCompetitionResultsByFiltersParam
        )
}