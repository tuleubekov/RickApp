package com.berg.rickapp.navigation.impl.di

import androidx.navigation.NavController
import com.berg.rickapp.navigation.api.NavigationApi
import com.berg.rickapp.home.navigation.HomeDirections
import com.berg.rickapp.home.navigation.HomeRouter
import com.berg.rickapp.navigation.impl.provider.NavigationActivityProvider
import com.berg.rickapp.navigation.impl.api.HomeNavigationImpl
import com.berg.rickapp.navigation.impl.api.HomeRouterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [NavigationModule.Binder::class])
class NavigationModule {

    @Provides
    fun provideTabsNavController(
        activityProvider: NavigationActivityProvider
    ): NavController {
        return activityProvider.get()
            ?.getNavigationFragment()
            ?.navController
            ?: error("Do not make navigation calls while activity is not available")
    }

    @Module
    interface Binder {

        @Binds
        fun bindHomeNavigation(impl: HomeNavigationImpl): NavigationApi<HomeDirections>

        @Binds
        fun bindHomeRouter(impl: HomeRouterImpl): HomeRouter
    }
}