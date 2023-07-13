package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.Exercise
import com.example.lizarun.domain.model.param.CreateExerciseParam
import com.example.lizarun.domain.repository.ExerciseRepository

class CreateExerciseUseCase(private val exerciseRepository: ExerciseRepository) : BaseUseCase<Exercise>() {
    operator fun invoke(createExerciseParam: CreateExerciseParam) =
        exerciseRepository.createExercise(param = createExerciseParam)
}