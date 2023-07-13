package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.Exercise
import com.example.lizarun.domain.model.param.GetExerciseByIdParam
import com.example.lizarun.domain.repository.ExerciseRepository

class GetExerciseByIdUseCase(private val exerciseRepository: ExerciseRepository) : BaseUseCase<Exercise>() {
    operator fun invoke(getExerciseByIdParam: GetExerciseByIdParam) =
        exerciseRepository.getExerciseById(param = getExerciseByIdParam)
}