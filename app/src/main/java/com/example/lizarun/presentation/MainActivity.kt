package com.example.lizarun.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.lizarun.databinding.ActivityMainBinding
import com.example.lizarun.domain.model.entity.UserRole
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initView()
        setContentView(binding.root)
    }

    private fun initView() = with(binding) {
        mainBindingViewModel = mainViewModel
        lifecycleOwner = this@MainActivity

        mainViewModel.registerUser(
            email = "user@example.com",
            birthDate = "2023-07-03T14:55:47.443Z",
            password = "admin1",
            passwordConfirm = "admin1",
            role = UserRole.Sportsman.value
        )
    }
}