package com.berg.rickapp.features.home.di

import com.berg.rickapp.core.presentation.di.AppViewModelFactory
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.di.ScreenScope
import dagger.Component

@ScreenScope
@Component(dependencies = [HomeFeatureDependencies::class], modules = [HomeFeatureModule::class])
interface HomeComponent {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeFeatureDependencies): HomeComponent
    }

    companion object {

        fun init(dep: HomeFeatureDependencies) = ComponentStorage.create(HomeComponent::class) {
            DaggerHomeComponent.factory().create(dep)
        }

        fun get() = ComponentStorage.get(HomeComponent::class)

        fun destroy() = ComponentStorage.remove(HomeComponent::class)
    }
}