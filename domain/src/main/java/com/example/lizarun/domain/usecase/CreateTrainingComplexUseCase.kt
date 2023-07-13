package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.TrainingComplex
import com.example.lizarun.domain.model.param.CreateTrainingComplexParam
import com.example.lizarun.domain.repository.TrainingComplexRepository

class CreateTrainingComplexUseCase(private val trainingComplexRepository: TrainingComplexRepository) : BaseUseCase<TrainingComplex>() {
    operator fun invoke(createTrainingComplexParam: CreateTrainingComplexParam) =
        trainingComplexRepository.createTrainingComplex(param = createTrainingComplexParam)
}