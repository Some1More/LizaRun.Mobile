package com.example.lizarun.domain.repository

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
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface WorkoutRepository {
    fun getWorkoutByDate(param: GetWorkoutByDateParam): Single<List<WorkoutInList>>

    fun getWorkoutById(param: GetWorkoutByIdParam): Single<Workout>

    fun createWorkout(param: CreateWorkoutParam): Single<WorkoutInList>

    fun writeCommentsToWorkout(param: WriteCommentsToWorkoutParam): Completable

    fun writeRecommendationsToWorkout(param: WriteRecommendationsToWorkoutParam): Completable

    fun updateWorkoutForTrainer(param: UpdateWorkoutForTrainerParam): Completable

    fun updateWorkoutForSportsman(param: UpdateWorkoutForSportsmanParam): Completable

    fun changeWorkoutExecutionStatus(param: ChangeWorkoutExecutionStatusParam): Completable

    fun deleteWorkout(param: DeleteWorkoutParam): Completable
}