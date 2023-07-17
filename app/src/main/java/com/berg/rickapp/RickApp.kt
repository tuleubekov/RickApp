package com.berg.rickapp

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.berg.rickapp.core.common.timberDebug
import com.berg.rickapp.di.AppComponent
import com.berg.rickapp.navigation.NavigationActivityProvider

class RickApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initAppComponent()
    }

    private fun initAppComponent() {
        AppComponent.create(NavigationActivityProvider(this))
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) timberDebug()
    }
}