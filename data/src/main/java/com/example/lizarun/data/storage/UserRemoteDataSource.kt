package com.example.lizarun.data.storage

import android.content.Context
import com.example.lizarun.data.storage.model.request.ChangeUserPasswordRequest
import com.example.lizarun.data.storage.model.request.FillSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.GetAccessTokenRequest
import com.example.lizarun.data.storage.model.request.GetUserByIdRequest
import com.example.lizarun.data.storage.model.request.LoginUserRequest
import com.example.lizarun.data.storage.model.request.RegisterUserRequest
import com.example.lizarun.data.storage.model.request.UpdateSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.UpdateUserDataRequest
import com.example.lizarun.data.storage.retrofit.LizaRunApiClient

class UserRemoteDataSource(context: Context) {
    private val apiService = LizaRunApiClient.getApiService(TokenLocalDataSource(context))

    fun getById(getUserByIdRequest: GetUserByIdRequest) = rxJavaSingleCall {
        apiService.getUserById(id = getUserByIdRequest.id)
    }

    fun getToken(getAccessTokenRequest: GetAccessTokenRequest) = rxJavaSingleCall {
        apiService.getAccessToken(requestBody = getAccessTokenRequest)
    }

    fun register(registerUserRequest: RegisterUserRequest) = rxJavaSingleCall {
        apiService.registerUser(requestBody = registerUserRequest)
    }

    fun login(loginUserRequest: LoginUserRequest) = rxJavaSingleCall {
        apiService.loginUser(requestBody = loginUserRequest)
    }

    fun logout() = rxJavaCompletableCall {
        apiService.logoutUser()
    }

    fun update(
        userId: String,
        updateUserDataRequest: UpdateUserDataRequest
    ) = rxJavaCompletableCall {
        apiService.updateUserData(id = userId, requestBody = updateUserDataRequest)
    }

    fun fillSportsman(
        sportsmanId: String,
        fillSportsmanDataRequest: FillSportsmanDataRequest
    ) = rxJavaCompletableCall {
        apiService.fillSportsmanData(id = sportsmanId, requestBody = fillSportsmanDataRequest)
    }

    fun updateSportsman(
        sportsmanId: String,
        updateSportsmanDataRequest: UpdateSportsmanDataRequest
    ) = rxJavaCompletableCall {
        apiService.updateSportsmanData(id = sportsmanId, requestBody = updateSportsmanDataRequest)
    }

    fun changePassword(changeUserPasswordRequest: ChangeUserPasswordRequest) = rxJavaCompletableCall {
        apiService.changeUserPassword(requestBody = changeUserPasswordRequest)
    }

    fun resetPassword() = rxJavaCompletableCall {
        apiService.resetUserPassword()
    }
}