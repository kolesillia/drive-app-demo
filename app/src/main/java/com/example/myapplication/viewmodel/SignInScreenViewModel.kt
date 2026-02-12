package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.SignInRequest
import com.example.myapplication.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInScreenViewModel : ViewModel() {

    private val _customerId = MutableStateFlow("")
    val customerId: StateFlow<String> = _customerId.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    fun onCustomerIdChange(newValue: String) {
        _customerId.value = newValue
    }

    fun onPasswordChange(newValue: String) {
        _password.value = newValue
    }

    fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {

            val request = SignInRequest(
                customerId = _customerId.value,
                password = _password.value
            )

            try {
                val response = ApiService.signIn(request)

                if (response.success) {
                    println("Token: ${response.token}")
                } else {
                    println("Error: ${response.message}")
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}