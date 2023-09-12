package com.berg.rickapp.features.splash.di

import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.presentation.base.AppViewModelFactory
import dagger.Component

@Component(dependencies = [SplashFeatureDependencies::class], modules = [SplashModule::class])
interface SplashComponent {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: SplashFeatureDependencies): SplashComponent
    }

    companion object {

        fun initAndGet() = ComponentStorage.getOrCreate(SplashComponent::class) {
            DaggerSplashComponent.factory().create(getSplashDependencies())
        }

        fun init(dependencies: SplashFeatureDependencies) =
            ComponentStorage.create(SplashComponent::class) {
                DaggerSplashComponent.factory().create(dependencies)
            }

        fun get() = ComponentStorage.get(SplashComponent::class)

        fun destroy() = ComponentStorage.remove(SplashComponent::class)
    }
}