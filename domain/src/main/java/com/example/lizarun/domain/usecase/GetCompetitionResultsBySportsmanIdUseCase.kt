package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionResultInList
import com.example.lizarun.domain.model.param.GetCompetitionResultsBySportsmanIdParam
import com.example.lizarun.domain.repository.CompetitionResultRepository

class GetCompetitionResultsBySportsmanIdUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<List<CompetitionResultInList>>() {
    operator fun invoke(
        getCompetitionResultsBySportsmanIdParam: GetCompetitionResultsBySportsmanIdParam
    ) = competitionResultRepository.getCompetitionResultsBySportsmanId(
        param = getCompetitionResultsBySportsmanIdParam
    )
}