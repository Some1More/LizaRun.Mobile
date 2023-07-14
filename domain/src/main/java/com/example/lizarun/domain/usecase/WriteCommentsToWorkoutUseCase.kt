package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.WriteCommentsToWorkoutParam
import com.example.lizarun.domain.repository.WorkoutRepository

class WriteCommentsToWorkoutUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Unit>() {
    operator fun invoke(writeCommentsToWorkoutParam: WriteCommentsToWorkoutParam) =
        workoutRepository.writeCommentsToWorkout(param = writeCommentsToWorkoutParam)
}