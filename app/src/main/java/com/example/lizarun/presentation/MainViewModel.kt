package com.example.lizarun.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lizarun.domain.model.entity.User
import com.example.lizarun.domain.model.param.GetUserByIdParam
import com.example.lizarun.domain.model.param.RegisterUserParam
import com.example.lizarun.domain.usecase.GetUserByIdUseCase
import com.example.lizarun.domain.usecase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun registerUser(
        email: String,
        birthDate: String,
        password: String,
        passwordConfirm: String,
        role: Int
    ) {
        val result = registerUserUseCase(
            RegisterUserParam(email, birthDate, password, passwordConfirm, role)
        ).flatMap {
            getUserByIdUseCase(
                GetUserByIdParam(id = it.userId)
            )
        }
        getUserByIdUseCase.getRxJavaResult(
            result,
            onSuccess = {
                _user.postValue(it)
            },
            onError = {
                Log.d("info", "${it.message}")
            }
        )
    }
}