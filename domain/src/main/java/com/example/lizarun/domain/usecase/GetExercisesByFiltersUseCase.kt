package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.ExerciseInList
import com.example.lizarun.domain.model.param.GetExercisesByFiltersParam
import com.example.lizarun.domain.repository.ExerciseRepository

class GetExercisesByFiltersUseCase(private val exerciseRepository: ExerciseRepository) : BaseUseCase<List<ExerciseInList>>() {
    operator fun invoke(getExercisesByFiltersParam: GetExercisesByFiltersParam) =
        exerciseRepository.getExercisesByFilters(param = getExercisesByFiltersParam)
}