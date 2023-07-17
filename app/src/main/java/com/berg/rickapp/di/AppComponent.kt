package com.berg.rickapp.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.details.di.DetailsComponentDependencies
import com.berg.rickapp.home.di.HomeComponentDependencies
import com.berg.rickapp.navigation.NavigationActivityProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, NavigationModule::class])
interface AppComponent : BaseAppComponent,
    HomeComponentDependencies,
    DetailsComponentDependencies
{

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activityProvider: NavigationActivityProvider
        ): AppComponent
    }

    companion object {
        fun create(activityProvider: NavigationActivityProvider): AppComponent {
            return ComponentStorage.getOrCreate(BaseAppComponent::class) {
                DaggerAppComponent.factory().create(activityProvider)
            } as AppComponent
        }
    }
}