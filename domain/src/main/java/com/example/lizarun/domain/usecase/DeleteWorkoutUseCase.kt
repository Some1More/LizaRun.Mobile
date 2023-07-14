package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.DeleteWorkoutParam
import com.example.lizarun.domain.repository.WorkoutRepository

class DeleteWorkoutUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Unit>() {
    operator fun invoke(deleteWorkoutParam: DeleteWorkoutParam) =
        workoutRepository.deleteWorkout(param = deleteWorkoutParam)
}