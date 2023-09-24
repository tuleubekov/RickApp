package com.berg.rickapp.features.splash.di

import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.features.splash.nav.SplashDirections

interface SplashFeatureDependencies {
    fun getSplashRouter(): NavigationApi<SplashDirections>
}