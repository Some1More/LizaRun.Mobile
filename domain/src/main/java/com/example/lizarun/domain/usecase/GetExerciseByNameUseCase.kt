package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.GetExerciseByNameParam
import com.example.lizarun.domain.repository.ExerciseRepository

class GetExerciseByNameUseCase(private val exerciseRepository: ExerciseRepository) {
    suspend operator fun invoke(getExerciseByNameParam: GetExerciseByNameParam) =
        exerciseRepository.getExerciseByName(param = getExerciseByNameParam)
}