package com.berg.rickapp.features.home.di

import com.berg.rickapp.core.di.AppViewModelFactory
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.di.ScreenScope
import dagger.Component

@ScreenScope
@Component(dependencies = [HomeComponentDependencies::class], modules = [HomeDataModule::class])
interface HomeComponent {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeComponentDependencies): HomeComponent
    }

    companion object {

        fun getOrCreate(): HomeComponent = ComponentStorage.getOrCreate(HomeComponent::class) {
            DaggerHomeComponent.factory().create(getHomeDependencies())
        }

        fun init(dep: HomeComponentDependencies) = ComponentStorage.create(HomeComponent::class) {
            DaggerHomeComponent.factory().create(dep)
        }

        fun get() = ComponentStorage.get(HomeComponent::class)

        fun destroy() = ComponentStorage.remove(HomeComponent::class)
    }
}