package com.berg.rickapp.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.details.di.DetailsComponentDependencies
import com.berg.rickapp.home.di.HomeComponentDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent : BaseAppComponent,
    HomeComponentDependencies,
    DetailsComponentDependencies
{
    companion object {
        fun create(): AppComponent {
            return DaggerAppComponent.create()
        }
    }
}