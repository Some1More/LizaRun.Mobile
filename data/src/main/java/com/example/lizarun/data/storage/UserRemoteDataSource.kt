package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.base.BaseRemoteDataSource
import com.example.lizarun.data.storage.model.request.ChangeUserPasswordRequest
import com.example.lizarun.data.storage.model.request.FillSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.GetAccessTokenRequest
import com.example.lizarun.data.storage.model.request.GetUserByIdRequest
import com.example.lizarun.data.storage.model.request.LoginUserRequest
import com.example.lizarun.data.storage.model.request.RegisterUserRequest
import com.example.lizarun.data.storage.model.request.UpdateSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.UpdateUserDataRequest

class UserRemoteDataSource(context: Context) : BaseRemoteDataSource(context) {
    suspend fun getById(getUserByIdRequest: GetUserByIdRequest) = apiRequestFlow {
        apiService.getUserById(id = getUserByIdRequest.id)
    }

    suspend fun getToken(getAccessTokenRequest: GetAccessTokenRequest) = apiRequestFlow {
        apiService.getAccessToken(requestBody = getAccessTokenRequest)
    }

    suspend fun register(registerUserRequest: RegisterUserRequest) = apiRequestFlow {
        apiService.registerUser(requestBody = registerUserRequest)
    }

    suspend fun login(loginUserRequest: LoginUserRequest) = apiRequestFlow {
        apiService.loginUser(requestBody = loginUserRequest)
    }

    suspend fun logout() = apiRequestFlow {
        apiService.logoutUser()
    }

    suspend fun update(
        userId: String,
        updateUserDataRequest: UpdateUserDataRequest
    ) = apiRequestFlow {
        apiService.updateUserData(id = userId, requestBody = updateUserDataRequest)
    }

    suspend fun fillSportsman(
        sportsmanId: String,
        fillSportsmanDataRequest: FillSportsmanDataRequest
    ) = apiRequestFlow {
        apiService.fillSportsmanData(id = sportsmanId, requestBody = fillSportsmanDataRequest)
    }

    suspend fun updateSportsman(
        sportsmanId: String,
        updateSportsmanDataRequest: UpdateSportsmanDataRequest
    ) = apiRequestFlow {
        apiService.updateSportsmanData(id = sportsmanId, requestBody = updateSportsmanDataRequest)
    }

    suspend fun changePassword(changeUserPasswordRequest: ChangeUserPasswordRequest) = apiRequestFlow {
        apiService.changeUserPassword(requestBody = changeUserPasswordRequest)
    }

    suspend fun resetPassword() = apiRequestFlow {
        apiService.resetUserPassword()
    }
}