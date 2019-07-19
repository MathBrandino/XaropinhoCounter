package com.wirecard.counter.di

import com.wirecard.counter.network.adp.AdpApi
import com.wirecard.counter.network.RetrofitInitializer
import org.koin.dsl.module

val network = module {
    single { RetrofitInitializer.retrofit }
    single { AdpApi(get()) }
}