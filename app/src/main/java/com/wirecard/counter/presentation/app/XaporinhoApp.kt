package com.wirecard.counter.presentation.app

import android.app.Application
import com.wirecard.counter.di.network
import com.wirecard.counter.di.repositories
import com.wirecard.counter.di.viewsModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class XaporinhoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@XaporinhoApp)
            modules(listOf(network, repositories, viewsModels))
        }
    }

}