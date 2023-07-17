package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionResultInList
import com.example.lizarun.domain.model.param.GetCompetitionResultsByCompetitionIdParam
import com.example.lizarun.domain.repository.CompetitionResultRepository

class GetCompetitionResultsByCompetitionIdUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<List<CompetitionResultInList>>() {
    operator fun invoke(
        getCompetitionResultsByCompetitionIdParam: GetCompetitionResultsByCompetitionIdParam
    ) = competitionResultRepository.getCompetitionResultsByCompetitionId(
            param = getCompetitionResultsByCompetitionIdParam
        )
}