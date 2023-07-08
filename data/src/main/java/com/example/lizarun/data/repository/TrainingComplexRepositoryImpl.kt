package com.example.lizarun.data.repository

import com.example.lizarun.data.mapper.mapToDomain
import com.example.lizarun.data.mapper.mapToStorage
import com.example.lizarun.data.storage.TrainingComplexRemoteDataSource
import com.example.lizarun.domain.model.entity.TrainingComplex
import com.example.lizarun.domain.model.param.CreateTrainingComplexParam
import com.example.lizarun.domain.model.param.DeleteTrainingComplexParam
import com.example.lizarun.domain.model.param.GetTrainingComplexByIdParam
import com.example.lizarun.domain.model.param.UpdateTrainingComplexParam
import com.example.lizarun.domain.repository.TrainingComplexRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class TrainingComplexRepositoryImpl(private val trainingComplexRemoteDataSource: TrainingComplexRemoteDataSource) : TrainingComplexRepository {
    override fun getAllTrainingComplexes(): Single<List<TrainingComplex>> {
        return trainingComplexRemoteDataSource.getAll().map {
            it.mapToDomain()
        }
    }

    override fun getTrainingComplexById(param: GetTrainingComplexByIdParam): Single<TrainingComplex> {
        val request = param.mapToStorage()
        return trainingComplexRemoteDataSource.getById(getTrainingComplexByIdRequest = request)
            .map {
                it.mapToDomain()
            }
    }

    override fun createTrainingComplex(param: CreateTrainingComplexParam): Single<TrainingComplex> {
        val request = param.mapToStorage()
        return trainingComplexRemoteDataSource.createNew(createTrainingComplexRequest = request)
            .map {
                it.mapToDomain()
            }
    }

    override fun updateTrainingComplex(param: UpdateTrainingComplexParam): Completable {
        val request = param.mapToStorage()
        return trainingComplexRemoteDataSource.update(
            trainingComplexId = param.id,
            updateTrainingComplexRequest = request
        )
    }

    override fun deleteTrainingComplex(param: DeleteTrainingComplexParam): Completable {
        val request = param.mapToStorage()
        return trainingComplexRemoteDataSource.delete(deleteTrainingComplexRequest = request)
    }
}