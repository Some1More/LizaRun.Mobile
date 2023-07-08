package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.CreateTrainingComplexParam
import com.example.lizarun.domain.repository.TrainingComplexRepository

class CreateTrainingComplexUseCase(private val trainingComplexRepository: TrainingComplexRepository) {
    operator fun invoke(createTrainingComplexParam: CreateTrainingComplexParam) =
        trainingComplexRepository.createTrainingComplex(param = createTrainingComplexParam)
}