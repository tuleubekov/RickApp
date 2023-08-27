package com.berg.rickapp.di

import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.navigation.impl.di.NavigationModule
import com.berg.rickapp.data.di.DataModule
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.domain.di.DomainModule
import com.berg.rickapp.features.splash.di.SplashFeatureDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    NavigationModule::class,
    DataModule::class,
    DomainModule::class,
    FeatureDependenciesModule::class,
    FeatureInjectorModule::class,
])
interface AppComponent : SplashFeatureDependencies {

    companion object {

        fun init() {
            val appComponent = DaggerAppComponent.create()
            ComponentStorage.create(AppComponent::class) { appComponent }
            ComponentStorage.create(SplashFeatureDependencies::class) { appComponent }
        }
    }
}