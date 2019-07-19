package com.wirecard.counter.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wirecard.counter.network.adp.AdpApi
import com.wirecard.counter.network.dto.AdpRequest

class UserRepository(private val api: AdpApi) {

    private val response: MutableLiveData<AdpRequest> = MutableLiveData()
    private val error: MutableLiveData<Throwable> = MutableLiveData()


    fun error() = error as LiveData<Throwable>
    fun response() = response as LiveData<AdpRequest>

    fun login(email: String, password: String) {
        api.login(email, password, sucess(), errorCallback())
    }

    private fun sucess() = { request: AdpRequest -> response.postValue(request) }
    private fun errorCallback() = { throwable: Throwable -> error.postValue(throwable) }

}
