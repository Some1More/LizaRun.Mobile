package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateWorkoutForSportsmanParam
import com.example.lizarun.domain.repository.WorkoutRepository

class UpdateWorkoutForSportsmanUseCase(private val workoutRepository: WorkoutRepository) : BaseUseCase<Unit>() {
    operator fun invoke(updateWorkoutForSportsmanParam: UpdateWorkoutForSportsmanParam) =
        workoutRepository.updateWorkoutForSportsman(param = updateWorkoutForSportsmanParam)
}