package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.Competition
import com.example.lizarun.domain.model.param.CreateCompetitionParam
import com.example.lizarun.domain.repository.CompetitionRepository

class CreateCompetitionUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<Competition>() {
    operator fun invoke(createCompetitionParam: CreateCompetitionParam) =
        competitionRepository.createCompetition(param = createCompetitionParam)
}