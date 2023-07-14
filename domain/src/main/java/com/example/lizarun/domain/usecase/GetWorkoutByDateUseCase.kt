package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.WorkoutInList
import com.example.lizarun.domain.model.param.GetWorkoutByDateParam
import com.example.lizarun.domain.repository.WorkoutRepository

class GetWorkoutByDateUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<List<WorkoutInList>>() {
    operator fun invoke(getWorkoutByDateParam: GetWorkoutByDateParam) =
        workoutRepository.getWorkoutByDate(param = getWorkoutByDateParam)
}