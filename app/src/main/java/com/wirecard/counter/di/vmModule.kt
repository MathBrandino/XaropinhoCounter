package com.wirecard.counter.di

import com.wirecard.counter.vm.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewsModels = module {
    viewModel { UserViewModel(get()) }
}