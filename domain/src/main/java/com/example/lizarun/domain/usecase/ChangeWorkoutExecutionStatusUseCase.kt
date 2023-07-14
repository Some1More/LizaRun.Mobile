package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.ChangeWorkoutExecutionStatusParam
import com.example.lizarun.domain.repository.WorkoutRepository

class ChangeWorkoutExecutionStatusUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Unit>() {
    operator fun invoke(changeWorkoutExecutionStatusParam: ChangeWorkoutExecutionStatusParam) =
        workoutRepository.changeWorkoutExecutionStatus(param = changeWorkoutExecutionStatusParam)
}