package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.DeleteCompetitionResultParam
import com.example.lizarun.domain.repository.CompetitionResultRepository

class DeleteCompetitionResultUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<Unit>() {
    operator fun invoke(deleteCompetitionResultParam: DeleteCompetitionResultParam) =
        competitionResultRepository.deleteCompetitionResult(param = deleteCompetitionResultParam)
}