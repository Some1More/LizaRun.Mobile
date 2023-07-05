package com.example.lizarun.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lizarun.domain.model.entity.AuthData
import com.example.lizarun.domain.model.param.RegisterUserParam
import com.example.lizarun.domain.model.doOnFailure
import com.example.lizarun.domain.model.doOnLoading
import com.example.lizarun.domain.model.doOnSuccess
import com.example.lizarun.domain.usecase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {
    private val _authData = MutableLiveData<AuthData>()
    val authData: LiveData<AuthData> = _authData

    fun registerUser(
        email: String,
        birthDate: String,
        password: String,
        passwordConfirm: String,
        role: Int
    ) = viewModelScope.launch {
        registerUserUseCase(
            RegisterUserParam(email, birthDate, password, passwordConfirm, role)
        ).doOnLoading {
            Log.d("info", "Registration...")
        }.doOnSuccess {
            _authData.postValue(it)
        }.doOnFailure { message, errorCode ->
            Log.d("info", "Register Failed: $message, $errorCode")
        }.collect()
    }
}