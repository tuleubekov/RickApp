package com.berg.rickapp.core.navigation.api

sealed class NavigationEvent {
    data class Forward(val hostId: Int, val id: Int): NavigationEvent()
    object Back: NavigationEvent()
}