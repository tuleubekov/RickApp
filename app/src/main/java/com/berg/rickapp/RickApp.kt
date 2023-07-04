package com.berg.rickapp

import android.app.Application
import com.berg.rickapp.di.AppComponent
import com.berg.rickapp.di.AppComponentInjector
import com.berg.rickapp.di.DaggerAppComponent
import com.berg.rickapp.di.Injector
import com.berg.rickapp.home.di.HomeComponentDependencies
import com.berg.rickapp.home.di.HomeComponentDependenciesProvider
import timber.log.Timber

class RickApp : Application(), HomeComponentDependenciesProvider {

    private val appComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun getHomeComponentDependencies(): HomeComponentDependencies {
        return appComponent
    }
}