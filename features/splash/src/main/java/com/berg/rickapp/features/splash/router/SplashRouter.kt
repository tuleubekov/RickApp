package com.berg.rickapp.features.splash.router

import com.berg.rickapp.core.navigation.api.NavigationEvent

interface SplashRouter {
    fun navigateToTabsFragment(): NavigationEvent
}