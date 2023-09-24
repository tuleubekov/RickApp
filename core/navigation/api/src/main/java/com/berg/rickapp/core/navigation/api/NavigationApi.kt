package com.berg.rickapp.core.navigation.api

import com.berg.rickapp.core.navigation.api.nav.NavigationEvent

interface NavigationApi<DIRECTION> {
    fun direct(direction: DIRECTION): NavigationEvent
}