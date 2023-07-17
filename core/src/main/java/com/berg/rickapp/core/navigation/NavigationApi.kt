package com.berg.rickapp.core.navigation

interface NavigationApi<DIRECTION> {
    fun navigate(direction: DIRECTION)
}