package com.example.lizarun.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lizarun.domain.model.entity.AuthData
import com.example.lizarun.domain.model.param.RegisterUserParam
import com.example.lizarun.domain.usecase.BaseUseCase
import com.example.lizarun.domain.usecase.GetUserByIdUseCase
import com.example.lizarun.domain.usecase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel(), BaseUseCase<AuthData> {
    private val _authData = MutableLiveData<AuthData>()
    val authData: LiveData<AuthData> = _authData

    fun registerUser(
        email: String,
        birthDate: String,
        password: String,
        passwordConfirm: String,
        role: Int
    ) {
        registerUserUseCase(
            RegisterUserParam(email, birthDate, password, passwordConfirm, role)
        ).executeUseCase(
            onSuccess = {

            },
            onError = {

            }
        )
    }
}