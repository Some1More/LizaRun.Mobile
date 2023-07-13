package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.DeleteTrainingComplexParam
import com.example.lizarun.domain.repository.TrainingComplexRepository

class DeleteTrainingComplexUseCase(private val trainingComplexRepository: TrainingComplexRepository) : BaseUseCase<Unit>() {
    operator fun invoke(deleteTrainingComplexParam: DeleteTrainingComplexParam) =
        trainingComplexRepository.deleteTrainingComplex(param = deleteTrainingComplexParam)
}