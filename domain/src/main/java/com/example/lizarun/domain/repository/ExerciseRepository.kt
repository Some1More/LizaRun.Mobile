package com.example.lizarun.domain.repository

import com.example.lizarun.domain.model.entity.Exercise
import com.example.lizarun.domain.model.entity.ExerciseInList
import com.example.lizarun.domain.model.param.CreateExerciseParam
import com.example.lizarun.domain.model.param.DeleteExerciseParam
import com.example.lizarun.domain.model.param.GetExerciseByIdParam
import com.example.lizarun.domain.model.param.GetExerciseByNameParam
import com.example.lizarun.domain.model.param.GetExercisesByFiltersParam
import com.example.lizarun.domain.model.param.UpdateExerciseParam
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ExerciseRepository {
    fun getAllExercises(): Single<List<ExerciseInList>>

    fun getExercisesByFilters(param: GetExercisesByFiltersParam): Single<List<ExerciseInList>>

    fun getExerciseById(param: GetExerciseByIdParam): Single<Exercise>

    fun getExerciseByName(param: GetExerciseByNameParam): Single<Exercise>

    fun createExercise(param: CreateExerciseParam): Single<Exercise>

    fun updateExercise(param: UpdateExerciseParam): Completable

    fun deleteExercise(param: DeleteExerciseParam): Completable
}