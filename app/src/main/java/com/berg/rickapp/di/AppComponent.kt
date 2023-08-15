package com.berg.rickapp.di

import com.berg.rickapp.core.common.di.BaseAppComponent
import com.berg.rickapp.core.common.di.ComponentStorage
import com.berg.rickapp.data.di.DataModule
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.details.di.DetailsComponentDependencies
import com.berg.rickapp.domain.di.DomainModule
import com.berg.rickapp.home.di.HomeComponentDependencies
import com.berg.rickapp.navigation.impl.di.NavigationModule
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
    HomeComponentDependencies,
    DetailsComponentDependencies
{

    companion object {
        fun init(): AppComponent {
            return ComponentStorage.getOrCreate(BaseAppComponent::class) {
                DaggerAppComponent.create()
            } as AppComponent
        }
    }
}