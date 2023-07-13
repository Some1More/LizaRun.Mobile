package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.AuthData
import com.example.lizarun.domain.model.param.LoginUserParam
import com.example.lizarun.domain.repository.UserRepository

class LoginUserUseCase(private val userRepository: UserRepository) : BaseUseCase<AuthData>() {
    operator fun invoke(loginUserParam: LoginUserParam) =
        userRepository.loginUser(param = loginUserParam)
}