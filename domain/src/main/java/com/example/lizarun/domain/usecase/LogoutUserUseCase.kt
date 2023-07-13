package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.repository.UserRepository

class LogoutUserUseCase(private val userRepository: UserRepository) : BaseUseCase<Unit>() {
    operator fun invoke() = userRepository.logoutUser()
}