package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.UpdateUserDataParam
import com.example.lizarun.domain.repository.UserRepository

class UpdateUserDataUseCase(private val userRepository: UserRepository) : BaseUseCase<Unit>() {
    operator fun invoke(updateUserDataParam: UpdateUserDataParam) =
        userRepository.updateUserData(param = updateUserDataParam)
}