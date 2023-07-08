package com.example.lizarun.domain.usecase

import com.example.lizarun.domain.model.param.GetAccessTokenParam
import com.example.lizarun.domain.repository.UserRepository

class GetAccessTokenUseCase(private val userRepository: UserRepository) {
    operator fun invoke(getAccessTokenParam: GetAccessTokenParam) =
        userRepository.getAccessToken(param = getAccessTokenParam)
}