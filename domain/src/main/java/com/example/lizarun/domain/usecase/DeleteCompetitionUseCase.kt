package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.DeleteCompetitionParam
import com.example.lizarun.domain.repository.CompetitionRepository

class DeleteCompetitionUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<Unit>() {
    operator fun invoke(deleteCompetitionParam: DeleteCompetitionParam) =
        competitionRepository.deleteCompetition(param = deleteCompetitionParam)
}