package com.berg.rickapp

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.berg.rickapp.common.utils.timberDebug
import com.berg.rickapp.di.AppComponent

class RickApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initComponents()
    }

    private fun initComponents() {
        AppComponent.init()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) timberDebug()
    }
}