package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.FillSportsmanDataParam
import com.example.lizarun.domain.repository.UserRepository

class FillSportsmanDataUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(fillSportsmanDataParam: FillSportsmanDataParam) =
        userRepository.fillSportsmanData(param = fillSportsmanDataParam)
}