package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.repository.UserRepository

class LogoutUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.logoutUser()
}