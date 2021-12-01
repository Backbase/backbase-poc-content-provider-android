package com.backbase.android.cms.client

import android.app.Application
import com.backbase.android.cms.client.di.appModule
import com.backbase.android.cms.client.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

/**
 * This the Main App Class
 * we load our dependencies here
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(networkModule, appModule))
        }


    }
}