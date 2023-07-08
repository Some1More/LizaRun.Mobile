package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateTrainingComplexParam
import com.example.lizarun.domain.repository.TrainingComplexRepository

class UpdateTrainingComplexUseCase(private val trainingComplexRepository: TrainingComplexRepository) {
    operator fun invoke(updateTrainingComplexParam: UpdateTrainingComplexParam) =
        trainingComplexRepository.updateTrainingComplex(param = updateTrainingComplexParam)
}