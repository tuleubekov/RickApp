package com.berg.rickapp.navigation.api

interface NavigationApi<DIRECTION> {
    fun navigate(direction: DIRECTION)
}