package com.berg.rickapp

import android.app.Application
import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.timberDebug
import com.berg.rickapp.di.AppComponent

class RickApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initAppComponent()
    }

    private fun initAppComponent() {
        ComponentStorage.getOrCreate(BaseAppComponent::class) { AppComponent.create() }
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) timberDebug()
    }
}