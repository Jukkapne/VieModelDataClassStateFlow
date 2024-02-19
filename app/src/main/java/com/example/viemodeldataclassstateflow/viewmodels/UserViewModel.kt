package com.example.viemodeldataclassstateflow.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.viemodeldataclassstateflow.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {
    private val _userInfo = MutableStateFlow<User?>(null)
    val userInfo: StateFlow<User?> = _userInfo

    fun saveUser(name: String, age: String, email: String) {
        _userInfo.value = User(name, age, email)
        Log.d("UserViewModel", "Tallennettu käyttäjä: $name, $age, $email")
    }

}
