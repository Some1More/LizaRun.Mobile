package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.entity.User
import com.example.lizarun.domain.model.param.GetUserByIdParam
import com.example.lizarun.domain.repository.UserRepository

class GetUserByIdUseCase(private val userRepository: UserRepository) : BaseUseCase<User>() {
    operator fun invoke(getUserByIdParam: GetUserByIdParam) =
        userRepository.getUserById(param = getUserByIdParam)
}