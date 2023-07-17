package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.model.param.GetCompetitionByFiltersParam
import com.example.lizarun.domain.repository.CompetitionRepository

class GetCompetitionByFiltersUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<List<CompetitionInList>>() {
    operator fun invoke(getCompetitionByFiltersParam: GetCompetitionByFiltersParam) =
        competitionRepository.getCompetitionByFilters(param = getCompetitionByFiltersParam)
}