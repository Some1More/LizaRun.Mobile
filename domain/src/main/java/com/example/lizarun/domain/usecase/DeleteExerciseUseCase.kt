package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.DeleteExerciseParam
import com.example.lizarun.domain.repository.ExerciseRepository

class DeleteExerciseUseCase(private val exerciseRepository: ExerciseRepository) {
    operator fun invoke(deleteExerciseParam: DeleteExerciseParam) =
        exerciseRepository.deleteExercise(param = deleteExerciseParam)
}