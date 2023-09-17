package com.berg.rickapp.core.navigation.api.router

import com.berg.rickapp.core.navigation.api.nav.NavigationEvent

interface HomeRouter {
    fun navigateToDetails(): NavigationEvent
    fun navigateToAbout(): NavigationEvent
}