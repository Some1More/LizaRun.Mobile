package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.repository.ExerciseRepository

class GetAllExercisesUseCase(private val exerciseRepository: ExerciseRepository) {
    operator fun invoke() = exerciseRepository.getAllExercises()
}