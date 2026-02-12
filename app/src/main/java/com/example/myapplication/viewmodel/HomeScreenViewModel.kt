package com.example.myapplication.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.myapplication.view.theme.White
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel : ViewModel() {

    val version = arrayOf(1, 3, 58583)

    private val _titleColor = MutableStateFlow(White)
    val titleColor: StateFlow<Color> = _titleColor.asStateFlow()

    private val _verNumber = MutableStateFlow(version)
    val verNumber: StateFlow<Array<Int>> = _verNumber.asStateFlow()

    fun toggleColor() {
        _titleColor.value = if (_titleColor.value == White) Color.Yellow else White
    }
}