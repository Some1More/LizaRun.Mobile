package com.example.lizarun.data.repository

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
import com.example.lizarun.domain.repository.UserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource) : UserRepository {
    override fun getUserById(param: GetUserByIdParam): Single<User> {
        val request = param.mapToStorage()
        return userRemoteDataSource.getById(getUserByIdRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun getAccessToken(param: GetAccessTokenParam): Single<AuthData> {
        val request = param.mapToStorage()
        return userRemoteDataSource.getToken(getAccessTokenRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun registerUser(param: RegisterUserParam): Single<AuthData> {
        val request = param.mapToStorage()
        return userRemoteDataSource.register(registerUserRequest = request).map {
            it.mapToDomain()
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun loginUser(param: LoginUserParam): Single<AuthData> {
        val request = param.mapToStorage()
        return userRemoteDataSource.login(loginUserRequest = request).map {
            it.mapToDomain()
        }
    }

    override fun logoutUser(): Completable {
        return userRemoteDataSource.logout()
    }

    override fun updateUserData(param: UpdateUserDataParam): Completable {
        val request = param.mapToStorage()
        return userRemoteDataSource.update(
            userId = param.userId,
            updateUserDataRequest = request
        )
    }

    override fun fillSportsmanData(param: FillSportsmanDataParam): Completable {
        val request = param.mapToStorage()
        return userRemoteDataSource.fillSportsman(
            sportsmanId = param.sportsmanId,
            fillSportsmanDataRequest = request
        )
    }

    override fun updateSportsmanData(param: UpdateSportsmanDataParam): Completable {
        val request = param.mapToStorage()
        return userRemoteDataSource.updateSportsman(
            sportsmanId = param.sportsmanId,
            updateSportsmanDataRequest = request
        )
    }

    override fun changeUserPassword(param: ChangeUserPasswordParam): Completable {
        val request = param.mapToStorage()
        return userRemoteDataSource.changePassword(changeUserPasswordRequest = request)
    }

    override fun resetUserPassword(): Completable {
        return userRemoteDataSource.resetPassword()
    }
}