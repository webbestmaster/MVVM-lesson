package com.statlex.mvvmlesson

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContactsViewModel : ViewModel() {
    var bgColor by mutableStateOf(Color.Green)
        private set

    fun changeBgColor() {
        viewModelScope.launch {
            delay(2000)
            bgColor = Color.Red
        }
    }
}