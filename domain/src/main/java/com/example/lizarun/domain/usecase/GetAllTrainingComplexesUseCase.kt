package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.repository.TrainingComplexRepository

class GetAllTrainingComplexesUseCase(private val trainingComplexRepository: TrainingComplexRepository) {
    operator fun invoke() = trainingComplexRepository.getAllTrainingComplexes()
}