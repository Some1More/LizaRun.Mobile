package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.GetTrainingComplexByIdParam
import com.example.lizarun.domain.repository.TrainingComplexRepository

class GetTrainingComplexByIdUseCase(private val trainingComplexRepository: TrainingComplexRepository) {
    operator fun invoke(getTrainingComplexByIdParam: GetTrainingComplexByIdParam) =
        trainingComplexRepository.getTrainingComplexById(param = getTrainingComplexByIdParam)
}