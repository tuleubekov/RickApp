package com.berg.rickapp.home.navigation

import com.berg.rickapp.core.presentation.nav.NavigationEvent

interface HomeRouter {
    fun navigateToDetails(): NavigationEvent
    fun navigateToAbout(): NavigationEvent
}