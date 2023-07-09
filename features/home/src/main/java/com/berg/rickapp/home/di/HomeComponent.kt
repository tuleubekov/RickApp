package com.berg.rickapp.home.di

import com.berg.rickapp.core.di.AppViewModelFactory
import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.di.ScreenScope
import dagger.Component

@ScreenScope
@Component(dependencies = [HomeComponentDependencies::class], modules = [HomeDataModule::class])
interface HomeComponent {

    fun viewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeComponentDependencies): HomeComponent
    }

    companion object {

        fun getOrCreate(): HomeComponent {
            val homeDependencies =
                ComponentStorage.get(BaseAppComponent::class) as HomeComponentDependencies
            return ComponentStorage.getOrCreate(HomeComponent::class) {
                DaggerHomeComponent.factory().create(homeDependencies)
            } as HomeComponent
        }

        fun destroy() {
            ComponentStorage.destroy(HomeComponent::class)
        }
    }
}