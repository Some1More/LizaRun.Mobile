package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.ExerciseInList
import com.example.lizarun.domain.repository.ExerciseRepository

class GetAllExercisesUseCase(private val exerciseRepository: ExerciseRepository) : BaseUseCase<List<ExerciseInList>>() {
    operator fun invoke() = exerciseRepository.getAllExercises()
}