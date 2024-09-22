package com.shreyanshsinghks.domain.di

import com.shreyanshsinghks.domain.usecase.GetProductUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
}