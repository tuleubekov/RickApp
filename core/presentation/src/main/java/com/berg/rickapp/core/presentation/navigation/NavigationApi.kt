package com.berg.rickapp.core.presentation.navigation

interface NavigationApi<DIRECTION> {
    fun navigate(direction: DIRECTION)
}