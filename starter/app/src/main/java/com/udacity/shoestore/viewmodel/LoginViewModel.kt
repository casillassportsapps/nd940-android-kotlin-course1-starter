package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _loginAccepted = MutableLiveData<Boolean>()
    val loginAccepted: LiveData<Boolean>
        get() = _loginAccepted

    fun onLogin() {
        _loginAccepted.value = true
    }

    fun onLoginAccepted() {
        _loginAccepted.value = false
    }
}