package com.berg.rickapp.di

import androidx.navigation.NavController
import com.berg.rickapp.core.navigation.NavigationApi
import com.berg.rickapp.home.navigation.HomeDirections
import com.berg.rickapp.navigation.NavigationActivityProvider
import com.berg.rickapp.navigation.api.HomeNavigationImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [NavigationModule.Binder::class])
class NavigationModule {

    @Provides
    fun provideNavController(
        activityProvider: NavigationActivityProvider
    ): NavController = activityProvider.get()
        ?.getNavigationFragment()
        ?.navController
        ?: error("Do not make navigation calls while activity is not available")

    @Module
    interface Binder {

        @Binds
        fun bindHomeNavigation(impl: HomeNavigationImpl): NavigationApi<HomeDirections>
    }
}