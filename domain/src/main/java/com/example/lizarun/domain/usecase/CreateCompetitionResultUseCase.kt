package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionResult
import com.example.lizarun.domain.repository.CompetitionResultRepository

class CreateCompetitionResultUseCase(
    private val competitionResultRepository: CompetitionResultRepository
) : BaseUseCase<CompetitionResult>() {
    operator fun invoke() = competitionResultRepository.createCompetitionResult()
}