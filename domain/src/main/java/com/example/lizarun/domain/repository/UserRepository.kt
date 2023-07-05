package com.example.lizarun.domain.repository

import com.example.lizarun.domain.model.entity.AuthData
import com.example.lizarun.domain.model.entity.User
import com.example.lizarun.domain.model.param.ChangeUserPasswordParam
import com.example.lizarun.domain.model.param.FillSportsmanDataParam
import com.example.lizarun.domain.model.param.GetAccessTokenParam
import com.example.lizarun.domain.model.param.GetUserByIdParam
import com.example.lizarun.domain.model.param.LoginUserParam
import com.example.lizarun.domain.model.param.RegisterUserParam
import com.example.lizarun.domain.model.param.UpdateSportsmanDataParam
import com.example.lizarun.domain.model.param.UpdateUserDataParam
import com.example.lizarun.domain.model.ApiResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserById(param: GetUserByIdParam): Flow<ApiResult<User>>

    suspend fun getAccessToken(param: GetAccessTokenParam): Flow<ApiResult<AuthData>>

    suspend fun registerUser(param: RegisterUserParam): Flow<ApiResult<AuthData>>

    suspend fun loginUser(param: LoginUserParam): Flow<ApiResult<AuthData>>

    suspend fun logoutUser(): Flow<ApiResult<Unit>>

    suspend fun updateUserData(param: UpdateUserDataParam): Flow<ApiResult<Unit>>

    suspend fun fillSportsmanData(param: FillSportsmanDataParam): Flow<ApiResult<Unit>>

    suspend fun updateSportsmanData(param: UpdateSportsmanDataParam): Flow<ApiResult<Unit>>

    suspend fun changeUserPassword(param: ChangeUserPasswordParam): Flow<ApiResult<Unit>>

    suspend fun resetUserPassword(): Flow<ApiResult<Unit>>
}