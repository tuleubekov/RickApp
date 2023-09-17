package com.berg.rickapp.core.navigation.api.nav

sealed interface NavigationEvent {
    data class Forward(val hostId: Int, val id: Int): NavigationEvent
    object Back: NavigationEvent
}