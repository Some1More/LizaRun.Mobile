package com.example.lizarun.data.repository

import com.example.lizarun.data.mapper.map
import com.example.lizarun.data.mapper.mapToDomain
import com.example.lizarun.data.mapper.mapToStorage
import com.example.lizarun.data.storage.UserRemoteDataSource
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
import com.example.lizarun.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource) : UserRepository {
    override suspend fun getUserById(param: GetUserByIdParam): Flow<ApiResult<User>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.getById(getUserByIdRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun getAccessToken(param: GetAccessTokenParam): Flow<ApiResult<AuthData>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.getToken(getAccessTokenRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun registerUser(param: RegisterUserParam): Flow<ApiResult<AuthData>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.register(registerUserRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun loginUser(param: LoginUserParam): Flow<ApiResult<AuthData>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.login(loginUserRequest = request).map { result ->
            result.map {
                it.mapToDomain()
            }
        }
    }

    override suspend fun logoutUser(): Flow<ApiResult<Unit>> {
        return userRemoteDataSource.logout().map { result ->
            result.map()
        }
    }

    override suspend fun updateUserData(param: UpdateUserDataParam): Flow<ApiResult<Unit>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.update(
            userId = param.userId,
            updateUserDataRequest = request
        ).map { result ->
            result.map()
        }
    }

    override suspend fun fillSportsmanData(param: FillSportsmanDataParam): Flow<ApiResult<Unit>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.fillSportsman(
            sportsmanId = param.sportsmanId,
            fillSportsmanDataRequest = request
        ).map { result ->
            result.map()
        }
    }

    override suspend fun updateSportsmanData(param: UpdateSportsmanDataParam): Flow<ApiResult<Unit>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.updateSportsman(
            sportsmanId = param.sportsmanId,
            updateSportsmanDataRequest = request
        ).map { result ->
            result.map()
        }
    }

    override suspend fun changeUserPassword(param: ChangeUserPasswordParam): Flow<ApiResult<Unit>> {
        val request = param.mapToStorage()
        return userRemoteDataSource.changePassword(changeUserPasswordRequest = request).map { result ->
            result.map()
        }
    }

    override suspend fun resetUserPassword(): Flow<ApiResult<Unit>> {
        return userRemoteDataSource.resetPassword().map { result ->
            result.map()
        }
    }
}