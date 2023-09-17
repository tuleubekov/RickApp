package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.navigation.api.NavApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface NavComponent : NavApi {

    companion object {

        fun get(): NavApi = ComponentStorage.getOrCreate(NavComponent::class) {
            DaggerNavComponent.create()
        }

    }
}