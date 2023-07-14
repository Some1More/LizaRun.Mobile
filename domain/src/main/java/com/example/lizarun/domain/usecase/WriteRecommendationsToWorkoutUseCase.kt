package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.WriteRecommendationsToWorkoutParam
import com.example.lizarun.domain.repository.WorkoutRepository

class WriteRecommendationsToWorkoutUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Unit>() {
    operator fun invoke(writeRecommendationsToWorkoutParam: WriteRecommendationsToWorkoutParam) =
        workoutRepository.writeRecommendationsToWorkout(param = writeRecommendationsToWorkoutParam)
}