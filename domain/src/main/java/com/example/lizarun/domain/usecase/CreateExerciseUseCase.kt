package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.CreateExerciseParam
import com.example.lizarun.domain.repository.ExerciseRepository

class CreateExerciseUseCase(private val exerciseRepository: ExerciseRepository) {
    suspend operator fun invoke(createExerciseParam: CreateExerciseParam) =
        exerciseRepository.createExercise(param = createExerciseParam)
}