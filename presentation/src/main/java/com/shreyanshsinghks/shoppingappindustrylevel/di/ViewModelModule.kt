package com.shreyanshsinghks.shoppingappindustrylevel.di

import com.shreyanshsinghks.shoppingappindustrylevel.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get(), get())
    }
}