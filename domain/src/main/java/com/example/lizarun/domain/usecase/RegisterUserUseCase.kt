package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.AuthData
import com.example.lizarun.domain.model.param.RegisterUserParam
import com.example.lizarun.domain.repository.UserRepository

class RegisterUserUseCase(private val userRepository: UserRepository) : BaseUseCase<AuthData>() {
    operator fun invoke(registerUserParam: RegisterUserParam) =
        userRepository.registerUser(param = registerUserParam)
}