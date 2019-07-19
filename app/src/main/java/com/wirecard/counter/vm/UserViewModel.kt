package com.wirecard.counter.vm

import androidx.lifecycle.ViewModel
import com.wirecard.counter.data.repository.UserRepository

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun logged() = repository.response()

    fun error() = repository.error()

    fun login(email: String, password: String) = repository.login(email, password)
}