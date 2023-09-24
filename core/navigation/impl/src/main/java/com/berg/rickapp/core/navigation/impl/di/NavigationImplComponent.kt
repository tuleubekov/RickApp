package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.core.di.ComponentStorage
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationImplModule::class])
interface NavigationImplComponent : NavigationImplApi {

    companion object {
        fun get(): NavigationImplApi =
            ComponentStorage.getOrCreate(NavigationImplComponent::class) {
                DaggerNavigationImplComponent.create()
            }
    }
}