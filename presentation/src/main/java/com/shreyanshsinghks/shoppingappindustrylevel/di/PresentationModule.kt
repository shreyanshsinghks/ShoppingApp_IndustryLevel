package com.shreyanshsinghks.shoppingappindustrylevel.di

import org.koin.dsl.module

val presentationModule = module {
    includes(viewModelModule)
}