package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.Workout
import com.example.lizarun.domain.model.param.GetWorkoutByIdParam
import com.example.lizarun.domain.repository.WorkoutRepository

class GetWorkoutByIdUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Workout>() {
    operator fun invoke(getWorkoutByIdParam: GetWorkoutByIdParam) =
        workoutRepository.getWorkoutById(param = getWorkoutByIdParam)
}