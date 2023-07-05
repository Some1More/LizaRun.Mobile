package com.example.lizarun.di

import android.content.Context
import com.example.lizarun.data.repository.UserRepositoryImpl
import com.example.lizarun.data.storage.UserRemoteDataSource
import com.example.lizarun.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideUserRemoteDataSource(@ApplicationContext context: Context) =
        UserRemoteDataSource(context = context)

    @Provides
    @Singleton
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): UserRepository {
        return UserRepositoryImpl(userRemoteDataSource = userRemoteDataSource)
    }
}