package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateSportsmanDataParam
import com.example.lizarun.domain.repository.UserRepository

class UpdateSportsmanDataUseCase(private val userRepository: UserRepository) : BaseUseCase<Unit>() {
    operator fun invoke(updateSportsmanDataParam: UpdateSportsmanDataParam) =
        userRepository.updateSportsmanData(param = updateSportsmanDataParam)
}