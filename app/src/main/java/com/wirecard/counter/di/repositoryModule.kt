package com.wirecard.counter.di

import com.wirecard.counter.data.repository.UserRepository
import org.koin.dsl.module

val repositories = module {
    single { UserRepository(get()) }
}