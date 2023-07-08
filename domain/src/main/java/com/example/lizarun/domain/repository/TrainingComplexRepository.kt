package com.example.lizarun.domain.repository

import com.example.lizarun.domain.model.entity.TrainingComplex
import com.example.lizarun.domain.model.param.CreateTrainingComplexParam
import com.example.lizarun.domain.model.param.DeleteTrainingComplexParam
import com.example.lizarun.domain.model.param.GetTrainingComplexByIdParam
import com.example.lizarun.domain.model.param.UpdateTrainingComplexParam
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface TrainingComplexRepository {
    fun getAllTrainingComplexes(): Single<List<TrainingComplex>>

    fun getTrainingComplexById(param: GetTrainingComplexByIdParam): Single<TrainingComplex>

    fun createTrainingComplex(param: CreateTrainingComplexParam): Single<TrainingComplex>

    fun updateTrainingComplex(param: UpdateTrainingComplexParam): Completable

    fun deleteTrainingComplex(param: DeleteTrainingComplexParam): Completable
}