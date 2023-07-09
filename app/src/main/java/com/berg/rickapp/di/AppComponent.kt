package com.berg.rickapp.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.home.di.HomeComponentDependencies
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent : BaseAppComponent, HomeComponentDependencies {
    companion object {
        fun create(): AppComponent {
            return DaggerAppComponent.create()
        }
    }
}