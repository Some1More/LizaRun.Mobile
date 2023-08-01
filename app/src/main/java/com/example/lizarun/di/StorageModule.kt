package com.example.lizarun.di

import android.content.Context
import com.example.lizarun.data.storage.CompetitionRemoteDataSource
import com.example.lizarun.data.storage.CompetitionResultRemoteDataSource
import com.example.lizarun.data.storage.ExerciseRemoteDataSource
import com.example.lizarun.data.storage.TokenLocalDataSource
import com.example.lizarun.data.storage.TrainingComplexRemoteDataSource
import com.example.lizarun.data.storage.UserRemoteDataSource
import com.example.lizarun.data.storage.WorkoutRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {
    @Provides
    @Singleton
    fun provideTokenLocalDataSource(@ApplicationContext context: Context) =
        TokenLocalDataSource(context = context)

    @Provides
    @Singleton
    fun provideUserRemoteDataSource(@ApplicationContext context: Context) =
        UserRemoteDataSource(context = context)

    @Provides
    @Singleton
    fun provideExerciseRemoteDataSource(@ApplicationContext context: Context) =
        ExerciseRemoteDataSource(context = context)

    @Provides
    @Singleton
    fun provideTrainingComplexRemoteDataSource(@ApplicationContext context: Context) =
        TrainingComplexRemoteDataSource(context = context)

    @Provides
    @Singleton
    fun provideWorkoutRemoteDataSource(@ApplicationContext context: Context) =
        WorkoutRemoteDataSource(context = context)

    @Provides
    @Singleton
    fun provideCompetitionRemoteDataSource(@ApplicationContext context: Context) =
        CompetitionRemoteDataSource(context = context)

    @Provides
    @Singleton
    fun provideCompetitionResultRemoteDataSource(@ApplicationContext context: Context) =
        CompetitionResultRemoteDataSource(context = context)
}