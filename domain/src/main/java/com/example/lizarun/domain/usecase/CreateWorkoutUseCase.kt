package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.WorkoutInList
import com.example.lizarun.domain.model.param.CreateWorkoutParam
import com.example.lizarun.domain.repository.WorkoutRepository

class CreateWorkoutUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<WorkoutInList>() {
    operator fun invoke(createWorkoutParam: CreateWorkoutParam) =
        workoutRepository.createWorkout(param = createWorkoutParam)
}