package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.core.navigation.impl.impl.HomeDirectionsImpl
import com.berg.rickapp.core.navigation.impl.impl.SplashDirectionsImpl
import com.berg.rickapp.features.home.nav.HomeDirections
import com.berg.rickapp.features.splash.nav.SplashDirections
import dagger.Binds
import dagger.Module

@Module
interface NavigationImplModule {

    @Binds
    fun bindSplashNavigationApi(impl: SplashDirectionsImpl): NavigationApi<SplashDirections>

    @Binds
    fun bindHomeNavigationApi(impl: HomeDirectionsImpl): NavigationApi<HomeDirections>
}