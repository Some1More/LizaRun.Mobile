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
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUserById(param: GetUserByIdParam): Single<User>

    fun getAccessToken(param: GetAccessTokenParam): Single<AuthData>

    fun registerUser(param: RegisterUserParam): Single<AuthData>

    fun loginUser(param: LoginUserParam): Single<AuthData>

    fun logoutUser(): Completable

    fun updateUserData(param: UpdateUserDataParam): Completable

    fun fillSportsmanData(param: FillSportsmanDataParam): Completable

    fun updateSportsmanData(param: UpdateSportsmanDataParam): Completable

    fun changeUserPassword(param: ChangeUserPasswordParam): Completable

    fun resetUserPassword(): Completable
}