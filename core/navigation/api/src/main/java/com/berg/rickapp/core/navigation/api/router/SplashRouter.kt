package com.berg.rickapp.core.navigation.api.router

import com.berg.rickapp.core.navigation.api.nav.NavigationEvent

interface SplashRouter {
    fun navigateToTabsFragment(): NavigationEvent
}