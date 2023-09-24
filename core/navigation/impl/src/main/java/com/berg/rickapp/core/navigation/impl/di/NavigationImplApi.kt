package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.features.home.nav.HomeDirections
import com.berg.rickapp.features.splash.nav.SplashDirections

interface NavigationImplApi {
    fun getSplashNavigationApi(): NavigationApi<SplashDirections>
    fun getHomeNavigationApi(): NavigationApi<HomeDirections>
}