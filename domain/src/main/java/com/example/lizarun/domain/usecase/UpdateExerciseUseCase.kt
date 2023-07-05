package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateExerciseParam
import com.example.lizarun.domain.repository.ExerciseRepository

class UpdateExerciseUseCase(private val exerciseRepository: ExerciseRepository) {
    suspend operator fun invoke(updateExerciseParam: UpdateExerciseParam) =
        exerciseRepository.updateExercise(param = updateExerciseParam)
}