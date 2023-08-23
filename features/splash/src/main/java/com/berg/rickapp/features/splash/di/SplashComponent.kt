package com.berg.rickapp.features.splash.di

import com.berg.rickapp.core.di.AppViewModelFactory
import com.berg.rickapp.core.di.ComponentStorage
import dagger.Component

@Component(dependencies = [SplashComponentDependencies::class], modules = [SplashModule::class])
interface SplashComponent {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: SplashComponentDependencies): SplashComponent
    }

    companion object {

        fun init() = ComponentStorage.create(SplashComponent::class) {
            DaggerSplashComponent.factory().create(getSplashDependencies())
        }

        fun get() = ComponentStorage.get(SplashComponent::class)

        fun destroy() = ComponentStorage.remove(SplashComponent::class)
    }
}