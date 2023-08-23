package com.berg.rickapp.di

import com.berg.rickapp.data.di.DataModule
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.features.details.di.DetailsComponentDependencies
import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.domain.di.DomainModule
import com.berg.rickapp.features.home.di.HomeComponentDependencies
import com.berg.rickapp.core.navigation.impl.di.NavigationModule
import com.berg.rickapp.features.splash.di.SplashComponentDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    NavigationModule::class,
    DataModule::class,
    DomainModule::class,
])
interface AppComponent : BaseAppComponent,
    SplashComponentDependencies,
    HomeComponentDependencies,
    DetailsComponentDependencies
{

    companion object {
        fun init() = ComponentStorage.getOrCreate(BaseAppComponent::class) {
            DaggerAppComponent.create() as AppComponent
        }
    }
}