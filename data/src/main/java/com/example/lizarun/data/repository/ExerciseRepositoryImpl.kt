package com.example.lizarun.data.repository

import com.example.lizarun.data.mapper.map
import com.example.lizarun.data.mapper.mapToDomain
import com.example.lizarun.data.mapper.mapToStorage
import com.example.lizarun.data.storage.ExerciseRemoteDataSource
import com.example.lizarun.domain.model.entity.Exercise
import com.example.lizarun.domain.model.entity.ExerciseInList
import com.example.lizarun.domain.model.param.CreateExerciseParam
import com.example.lizarun.domain.model.param.DeleteExerciseParam
import com.example.lizarun.domain.model.param.GetExerciseByIdParam
import com.example.lizarun.domain.model.param.GetExerciseByNameParam
import com.example.lizarun.domain.model.param.GetExercisesByFiltersParam
import com.example.lizarun.domain.model.param.UpdateExerciseParam
import com.example.lizarun.domain.model.ApiResult
import com.example.lizarun.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExerciseRepositoryImpl(private val exerciseRemoteDataSource: ExerciseRemoteDataSource) : ExerciseRepository {
    override suspend fun getAllExercises(): Flow<ApiResult<List<ExerciseInList>>> {
        return exerciseRemoteDataSource.getAll().map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun getExercisesByFilters(param: GetExercisesByFiltersParam): Flow<ApiResult<List<ExerciseInList>>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.getByFilters(getExercisesByFiltersRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun getExerciseById(param: GetExerciseByIdParam): Flow<ApiResult<Exercise>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.getById(getExerciseByIdRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun getExerciseByName(param: GetExerciseByNameParam): Flow<ApiResult<Exercise>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.getByName(getExerciseByNameRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun createExercise(param: CreateExerciseParam): Flow<ApiResult<Exercise>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.createNew(createExerciseRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun updateExercise(param: UpdateExerciseParam): Flow<ApiResult<Unit>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.update(
            exerciseId = param.id,
            updateExerciseRequest = request
        ).map { result ->
            result.map()
        }
    }

    override suspend fun deleteExercise(param: DeleteExerciseParam): Flow<ApiResult<Unit>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.delete(deleteExerciseRequest = request).map { result ->
            result.map()
        }
    }
}