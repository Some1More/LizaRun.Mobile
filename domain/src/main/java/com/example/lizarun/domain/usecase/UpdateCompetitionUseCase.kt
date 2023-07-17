package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateCompetitionParam
import com.example.lizarun.domain.repository.CompetitionRepository

class UpdateCompetitionUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<Unit>() {
    operator fun invoke(updateCompetitionParam: UpdateCompetitionParam) =
        competitionRepository.updateCompetition(param = updateCompetitionParam)
}