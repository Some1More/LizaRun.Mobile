package com.example.lizarun.presentation

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
        val call = registerUserUseCase(
            RegisterUserParam(email, birthDate, password, passwordConfirm, role)
        ).flatMap { authData ->
            getUserByIdUseCase(
                GetUserByIdParam(id = authData.userId)
            ).doOnSubscribe {

            }.doOnSuccess {
                _user.value = it
            }.doOnError {

            }.doFinally {

            }
        }
        getUserByIdUseCase.execute(call)
    }
}