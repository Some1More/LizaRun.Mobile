package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.Competition
import com.example.lizarun.domain.model.param.GetCompetitionByIdParam
import com.example.lizarun.domain.repository.CompetitionRepository

class GetCompetitionByIdUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<Competition>() {
    operator fun invoke(getCompetitionByIdParam: GetCompetitionByIdParam) =
        competitionRepository.getCompetitionById(param = getCompetitionByIdParam)
}
