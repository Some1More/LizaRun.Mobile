package com.example.lizarun.data.repository

import com.example.lizarun.data.mapper.mapToDomain
import com.example.lizarun.data.mapper.mapToStorage
import com.example.lizarun.data.storage.WorkoutRemoteDataSource
import com.example.lizarun.domain.model.entity.Workout
import com.example.lizarun.domain.model.entity.WorkoutInList
import com.example.lizarun.domain.model.param.ChangeWorkoutExecutionStatusParam
import com.example.lizarun.domain.model.param.CreateWorkoutParam
import com.example.lizarun.domain.model.param.DeleteWorkoutParam
import com.example.lizarun.domain.model.param.GetWorkoutByDateParam
import com.example.lizarun.domain.model.param.GetWorkoutByIdParam
import com.example.lizarun.domain.model.param.UpdateWorkoutForSportsmanParam
import com.example.lizarun.domain.model.param.UpdateWorkoutForTrainerParam
import com.example.lizarun.domain.model.param.WriteCommentsToWorkoutParam
import com.example.lizarun.domain.model.param.WriteRecommendationsToWorkoutParam
import com.example.lizarun.domain.repository.WorkoutRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class WorkoutRepositoryImpl(private val workoutRemoteDataSource: WorkoutRemoteDataSource) : WorkoutRepository {
    override fun getWorkoutByDate(param: GetWorkoutByDateParam): Single<List<WorkoutInList>> {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.getByDate(getWorkoutByDateRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun getWorkoutById(param: GetWorkoutByIdParam): Single<Workout> {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.getById(getWorkoutByIdRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun createWorkout(param: CreateWorkoutParam): Single<WorkoutInList> {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.createNew(createWorkoutRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun writeCommentsToWorkout(param: WriteCommentsToWorkoutParam): Completable {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.writeComments(writeCommentsToWorkoutRequest = request)
    }

    override fun writeRecommendationsToWorkout(param: WriteRecommendationsToWorkoutParam): Completable {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.writeRecommendations(writeRecommendationsToWorkoutRequest = request)
    }

    override fun updateWorkoutForTrainer(param: UpdateWorkoutForTrainerParam): Completable {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.updateForTrainer(
            workoutId = param.id,
            updateWorkoutForTrainerRequest = request
        )
    }

    override fun updateWorkoutForSportsman(param: UpdateWorkoutForSportsmanParam): Completable {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.updateForSportsman(
            workoutId = param.id,
            updateWorkoutForSportsmanRequest = request
        )
    }

    override fun changeWorkoutExecutionStatus(param: ChangeWorkoutExecutionStatusParam): Completable {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.changeExecutionStatus(changeWorkoutExecutionStatusRequest = request)
    }

    override fun deleteWorkout(param: DeleteWorkoutParam): Completable {
        val request = param.mapToStorage()
        return workoutRemoteDataSource.delete(deleteWorkoutRequest = request)
    }
}