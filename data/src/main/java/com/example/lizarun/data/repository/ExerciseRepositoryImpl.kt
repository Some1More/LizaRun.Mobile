package com.example.lizarun.data.repository

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
import com.example.lizarun.domain.repository.ExerciseRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class ExerciseRepositoryImpl(private val exerciseRemoteDataSource: ExerciseRemoteDataSource) : ExerciseRepository {
    override fun getAllExercises(): Single<List<ExerciseInList>> {
        return exerciseRemoteDataSource.getAll().map {
            it.mapToDomain()
        }
    }

    override fun getExercisesByFilters(param: GetExercisesByFiltersParam): Single<List<ExerciseInList>> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.getByFilters(getExercisesByFiltersRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun getExerciseById(param: GetExerciseByIdParam): Single<Exercise> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.getById(getExerciseByIdRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun getExerciseByName(param: GetExerciseByNameParam): Single<Exercise> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.getByName(getExerciseByNameRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun createExercise(param: CreateExerciseParam): Single<Exercise> {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.createNew(createExerciseRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun updateExercise(param: UpdateExerciseParam): Completable {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.update(
            exerciseId = param.id,
            updateExerciseRequest = request
        )
    }

    override fun deleteExercise(param: DeleteExerciseParam): Completable {
        val request = param.mapToStorage()
        return exerciseRemoteDataSource.delete(deleteExerciseRequest = request)
    }
}