package com.wirecard.counter.network.adp

import android.util.Log
import com.wirecard.counter.network.dto.AdpRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.NullPointerException


class AdpApi(retrofit: Retrofit) {

    private val service by lazy {
        retrofit.create(AdpService::class.java)
    }


    fun login(
        email: String,
        password: String,
        dealWith: (AdpRequest) -> Unit,
        dealWithError: (Throwable) -> Unit
    ) {

        service.login(email, password).enqueue(object : Callback<ResponseBody?> {
            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {

                dealWithError(t)

            }

            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {

                val headers = response.headers()
                val cookie = headers.get("Set-Cookie")
                val html = response.body()?.string()

                val cookieValue = cookie?.split(";")?.get(0)?.split("=")?.get(1)
                val href = html
                    ?.substringAfterLast("<script language=\"JavaScript\">")
                    ?.substringBeforeLast("</script>")
                    ?.substringAfterLast("location.href = ")


                if (!href.isNullOrBlank() && !cookieValue.isNullOrBlank())
                    dealWith(AdpRequest(href, cookieValue))
                else
                    dealWithError(NullPointerException())


            }
        })

    }
}