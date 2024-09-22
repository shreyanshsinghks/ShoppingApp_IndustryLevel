package com.shreyanshsinghks.shoppingappindustrylevel

import android.app.Application
import com.shreyanshsinghks.data.di.dataModule
import com.shreyanshsinghks.domain.di.domainModule
import com.shreyanshsinghks.shoppingappindustrylevel.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopperApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShopperApp)
            modules(
                listOf(
                    presentationModule,
                    dataModule,
                    domainModule
                )
            )
        }
    }

}