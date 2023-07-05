package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.response.AuthDataResponse
import com.example.lizarun.data.storage.model.request.ChangeUserPasswordRequest
import com.example.lizarun.data.storage.model.request.FillSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.GetAccessTokenRequest
import com.example.lizarun.data.storage.model.request.GetUserByIdRequest
import com.example.lizarun.data.storage.model.request.LoginUserRequest
import com.example.lizarun.data.storage.model.request.RegisterUserRequest
import com.example.lizarun.data.storage.model.request.UpdateSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.UpdateUserDataRequest
import com.example.lizarun.data.storage.model.response.UserResponse
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

fun UserResponse.mapToDomain(): User {
    return User(
        id = id,
        email = email,
        phoneNumber = phoneNumber,
        firstname = firstname,
        middlename = middlename,
        surname = surname,
        birthDate = birthDate.mapToDomain(),
        telegramLink = telegramLink,
        photo = photo,
        trainingComplexes = trainingComplexes.mapToDomain()
    )
}

fun AuthDataResponse.mapToDomain(): AuthData {
    return AuthData(
        userId = userId,
        expiresIn = expiresIn,
        tokenType = tokenType,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}

fun ChangeUserPasswordParam.mapToStorage(): ChangeUserPasswordRequest {
    return ChangeUserPasswordRequest(
        email = email,
        oldPassword = oldPassword,
        newPassword = newPassword
    )
}

fun FillSportsmanDataParam.mapToStorage(): FillSportsmanDataRequest {
    return FillSportsmanDataRequest(
        trainerId = trainerId,
        bibNumber = bibNumber,
        height = height,
        width = width,
        sportClass = sportClass,
        baseDistances = baseDistances,
        trainingPurpose = trainingPurpose,
        peculiarities = peculiarities,
        teamId = teamId,
        gender = gender
    )
}

fun GetAccessTokenParam.mapToStorage(): GetAccessTokenRequest {
    return GetAccessTokenRequest(refreshToken = refreshToken)
}

fun GetUserByIdParam.mapToStorage(): GetUserByIdRequest {
    return GetUserByIdRequest(id = id)
}

fun LoginUserParam.mapToStorage(): LoginUserRequest {
    return LoginUserRequest(
        email = email,
        password = password
    )
}

fun RegisterUserParam.mapToStorage(): RegisterUserRequest {
    return RegisterUserRequest(
        email = email,
        birthDate = birthDate,
        password = password,
        passwordConfirm = passwordConfirm,
        role = role
    )
}

fun UpdateSportsmanDataParam.mapToStorage(): UpdateSportsmanDataRequest {
    return UpdateSportsmanDataRequest(
        trainerId = trainerId,
        bibNumber = bibNumber,
        height = height,
        width = width,
        sportClass = sportClass,
        baseDistances = baseDistances,
        trainingPurpose = trainingPurpose,
        peculiarities = peculiarities,
        teamId = teamId
    )
}

fun UpdateUserDataParam.mapToStorage(): UpdateUserDataRequest {
    return UpdateUserDataRequest(
        firstname = firstname,
        middlename = middlename,
        surname = surname,
        birthDate = birthDate.mapToStorage(),
        telegramLink = telegramLink,
        photo = photo
    )
}