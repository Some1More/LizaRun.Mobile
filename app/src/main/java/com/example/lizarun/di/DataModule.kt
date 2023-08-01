package com.example.lizarun.di

import com.example.lizarun.data.repository.CompetitionRepositoryImpl
import com.example.lizarun.data.repository.CompetitionResultRepositoryImpl
import com.example.lizarun.data.repository.ExerciseRepositoryImpl
import com.example.lizarun.data.repository.TrainingComplexRepositoryImpl
import com.example.lizarun.data.repository.UserRepositoryImpl
import com.example.lizarun.data.repository.WorkoutRepositoryImpl
import com.example.lizarun.data.storage.CompetitionRemoteDataSource
import com.example.lizarun.data.storage.CompetitionResultRemoteDataSource
import com.example.lizarun.data.storage.ExerciseRemoteDataSource
import com.example.lizarun.data.storage.TrainingComplexRemoteDataSource
import com.example.lizarun.data.storage.UserRemoteDataSource
import com.example.lizarun.data.storage.WorkoutRemoteDataSource
import com.example.lizarun.domain.repository.CompetitionRepository
import com.example.lizarun.domain.repository.CompetitionResultRepository
import com.example.lizarun.domain.repository.ExerciseRepository
import com.example.lizarun.domain.repository.TrainingComplexRepository
import com.example.lizarun.domain.repository.UserRepository
import com.example.lizarun.domain.repository.WorkoutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): UserRepository {
        return UserRepositoryImpl(userRemoteDataSource = userRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideExerciseRepository(exerciseRemoteDataSource: ExerciseRemoteDataSource): ExerciseRepository {
        return ExerciseRepositoryImpl(exerciseRemoteDataSource = exerciseRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideTrainingComplexRepository(
        trainingComplexRemoteDataSource: TrainingComplexRemoteDataSource
    ): TrainingComplexRepository {
        return TrainingComplexRepositoryImpl(trainingComplexRemoteDataSource = trainingComplexRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideWorkoutRepository(workoutRemoteDataSource: WorkoutRemoteDataSource): WorkoutRepository {
        return WorkoutRepositoryImpl(workoutRemoteDataSource = workoutRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideCompetitionRepository(competitionRemoteDataSource: CompetitionRemoteDataSource): CompetitionRepository {
        return CompetitionRepositoryImpl(competitionRemoteDataSource = competitionRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideCompetitionResultRepository(
        competitionResultRemoteDataSource: CompetitionResultRemoteDataSource
    ): CompetitionResultRepository {
        return CompetitionResultRepositoryImpl(competitionResultRemoteDataSource = competitionResultRemoteDataSource)
    }
}