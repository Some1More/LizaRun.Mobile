package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateWorkoutForTrainerParam
import com.example.lizarun.domain.repository.WorkoutRepository

class UpdateWorkoutForTrainerUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Unit>() {
    operator fun invoke(updateWorkoutForTrainerParam: UpdateWorkoutForTrainerParam) =
        workoutRepository.updateWorkoutForTrainer(param = updateWorkoutForTrainerParam)
}