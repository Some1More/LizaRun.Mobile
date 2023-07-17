package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateCompetitionResultParam
import com.example.lizarun.domain.repository.CompetitionResultRepository

class UpdateCompetitionResultUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<Unit>() {
    operator fun invoke(updateCompetitionResultParam: UpdateCompetitionResultParam) =
        competitionResultRepository.updateCompetitionResult(param = updateCompetitionResultParam)
}