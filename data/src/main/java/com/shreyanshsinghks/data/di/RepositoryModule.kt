package com.shreyanshsinghks.data.di

import com.shreyanshsinghks.data.repository.ProductRepositoryImpl
import com.shreyanshsinghks.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}