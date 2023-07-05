package com.example.lizarun.di

import com.example.lizarun.domain.repository.UserRepository
import com.example.lizarun.domain.usecase.ChangeUserPasswordUseCase
import com.example.lizarun.domain.usecase.FillSportsmanDataUseCase
import com.example.lizarun.domain.usecase.GetAccessTokenUseCase
import com.example.lizarun.domain.usecase.GetUserByIdUseCase
import com.example.lizarun.domain.usecase.LoginUserUseCase
import com.example.lizarun.domain.usecase.LogoutUserUseCase
import com.example.lizarun.domain.usecase.RegisterUserUseCase
import com.example.lizarun.domain.usecase.ResetUserPasswordUseCase
import com.example.lizarun.domain.usecase.UpdateSportsmanDataUseCase
import com.example.lizarun.domain.usecase.UpdateUserDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetUserByIdUseCase(userRepository: UserRepository) =
        GetUserByIdUseCase(userRepository = userRepository)

    @Provides
    fun provideGetAccessTokenUseCase(userRepository: UserRepository) =
        GetAccessTokenUseCase(userRepository = userRepository)

    @Provides
    fun provideRegisterUserUseCase(userRepository: UserRepository) =
        RegisterUserUseCase(userRepository = userRepository)

    @Provides
    fun provideLoginUserUseCase(userRepository: UserRepository) =
        LoginUserUseCase(userRepository = userRepository)

    @Provides
    fun provideLogoutUserUseCase(userRepository: UserRepository) =
        LogoutUserUseCase(userRepository = userRepository)

    @Provides
    fun provideUpdateUserDataUseCase(userRepository: UserRepository) =
        UpdateUserDataUseCase(userRepository = userRepository)

    @Provides
    fun provideFillSportsmanDataUseCase(userRepository: UserRepository) =
        FillSportsmanDataUseCase(userRepository = userRepository)

    @Provides
    fun provideUpdateSportsmanDataUseCase(userRepository: UserRepository) =
        UpdateSportsmanDataUseCase(userRepository = userRepository)

    @Provides
    fun provideChangeUserPasswordUseCase(userRepository: UserRepository) =
        ChangeUserPasswordUseCase(userRepository = userRepository)

    @Provides
    fun provideResetUserPasswordUseCase(userRepository: UserRepository) =
        ResetUserPasswordUseCase(userRepository = userRepository)
}