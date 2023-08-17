package com.berg.rickapp.features.home.router

import com.berg.rickapp.core.navigation.api.NavigationEvent

interface HomeRouter {
    fun navigateToDetails(): NavigationEvent
    fun navigateToAbout(): NavigationEvent
}