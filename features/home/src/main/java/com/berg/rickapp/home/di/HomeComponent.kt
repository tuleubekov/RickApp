package com.berg.rickapp.home.di

import com.berg.rickapp.core.presentation.di.AppViewModelFactory
import com.berg.rickapp.core.common.di.ComponentStorage
import com.berg.rickapp.core.common.di.ScreenScope
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

        fun destroy() = ComponentStorage.remove(HomeComponent::class)
    }
}