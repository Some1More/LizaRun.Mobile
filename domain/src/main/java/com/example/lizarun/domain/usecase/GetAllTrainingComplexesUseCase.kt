package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.TrainingComplex
import com.example.lizarun.domain.repository.TrainingComplexRepository

class GetAllTrainingComplexesUseCase(private val trainingComplexRepository: TrainingComplexRepository) : BaseUseCase<List<TrainingComplex>>() {
    operator fun invoke() = trainingComplexRepository.getAllTrainingComplexes()
}