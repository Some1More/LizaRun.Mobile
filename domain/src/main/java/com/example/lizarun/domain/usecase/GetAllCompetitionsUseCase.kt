package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.CompetitionInList
import com.example.lizarun.domain.repository.CompetitionRepository

class GetAllCompetitionsUseCase(private val competitionRepository: CompetitionRepository) : BaseUseCase<List<CompetitionInList>>() {
    operator fun invoke() = competitionRepository.getAllCompetitions()
}