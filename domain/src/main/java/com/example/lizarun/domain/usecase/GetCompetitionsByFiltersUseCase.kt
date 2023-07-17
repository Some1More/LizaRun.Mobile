package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.model.param.GetCompetitionsByFiltersParam
import com.example.lizarun.domain.repository.CompetitionRepository

class GetCompetitionsByFiltersUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<List<CompetitionInList>>() {
    operator fun invoke(getCompetitionsByFiltersParam: GetCompetitionsByFiltersParam) =
        competitionRepository.getCompetitionsByFilters(param = getCompetitionsByFiltersParam)
}