package com.berg.rickapp

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.berg.rickapp.core.common.timberDebug
import com.berg.rickapp.di.AppComponent

class RickApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initAppComponent()
    }

    private fun initAppComponent() {
        AppComponent.init()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) timberDebug()
    }
}