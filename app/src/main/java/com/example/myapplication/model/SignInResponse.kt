package com.example.myapplication.model

data class SignInResponse(
    val success: Boolean,
    val token: String?,
    val message: String?
)