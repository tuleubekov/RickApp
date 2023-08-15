package com.berg.rickapp.core.presentation.nav

sealed class NavigationEvent {
    data class Forward(val hostId: Int, val id: Int): NavigationEvent()
    object Back: NavigationEvent()
}