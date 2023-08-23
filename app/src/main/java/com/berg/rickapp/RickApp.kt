package com.berg.rickapp

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.berg.rickapp.common.utils.timberDebug
import com.berg.rickapp.di.AppComponent
import com.berg.rickapp.features.splash.di.SplashComponent

class RickApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initComponents()
    }

    private fun initComponents() {
        AppComponent.init()
        SplashComponent.init()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) timberDebug()
    }
}