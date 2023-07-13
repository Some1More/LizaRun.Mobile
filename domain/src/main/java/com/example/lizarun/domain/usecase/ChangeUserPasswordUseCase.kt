package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.ChangeUserPasswordParam
import com.example.lizarun.domain.repository.UserRepository

class ChangeUserPasswordUseCase(private val userRepository: UserRepository) : BaseUseCase<Unit>() {
    operator fun invoke(changeUserPasswordParam: ChangeUserPasswordParam) =
        userRepository.changeUserPassword(param = changeUserPasswordParam)
}