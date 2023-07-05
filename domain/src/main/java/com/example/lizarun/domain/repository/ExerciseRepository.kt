package com.example.lizarun.domain.repository

import com.example.lizarun.domain.model.entity.Exercise
import com.example.lizarun.domain.model.entity.ExerciseInList
import com.example.lizarun.domain.model.param.CreateExerciseParam
import com.example.lizarun.domain.model.param.DeleteExerciseParam
import com.example.lizarun.domain.model.param.GetExerciseByIdParam
import com.example.lizarun.domain.model.param.GetExerciseByNameParam
import com.example.lizarun.domain.model.param.GetExercisesByFiltersParam
import com.example.lizarun.domain.model.param.UpdateExerciseParam
import com.example.lizarun.domain.model.ApiResult
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {
    suspend fun getAllExercises(): Flow<ApiResult<List<ExerciseInList>>>

    suspend fun getExercisesByFilters(param: GetExercisesByFiltersParam): Flow<ApiResult<List<ExerciseInList>>>

    suspend fun getExerciseById(param: GetExerciseByIdParam): Flow<ApiResult<Exercise>>

    suspend fun getExerciseByName(param: GetExerciseByNameParam): Flow<ApiResult<Exercise>>

    suspend fun createExercise(param: CreateExerciseParam): Flow<ApiResult<Exercise>>

    suspend fun updateExercise(param: UpdateExerciseParam): Flow<ApiResult<Unit>>

    suspend fun deleteExercise(param: DeleteExerciseParam): Flow<ApiResult<Unit>>
}