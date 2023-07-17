package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionResult
import com.example.lizarun.domain.model.param.GetCompetitionResultByIdParam
import com.example.lizarun.domain.repository.CompetitionResultRepository

class GetCompetitionResultByIdUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<CompetitionResult>() {
    operator fun invoke(getCompetitionResultByIdParam: GetCompetitionResultByIdParam) =
        competitionResultRepository.getCompetitionResultById(
            param = getCompetitionResultByIdParam
        )
}