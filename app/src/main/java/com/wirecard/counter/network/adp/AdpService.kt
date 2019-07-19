package com.wirecard.counter.network.adp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AdpService {

    @POST("revbr/sso.exe/WService=ssoprologin/rev-loginsso")
    @FormUrlEncoded
    fun login(
        @Field("login") login: String,
        @Field("login-pw") password: String
    ): Call<ResponseBody>
}