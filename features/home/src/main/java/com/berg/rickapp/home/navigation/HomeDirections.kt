package com.berg.rickapp.home.navigation

sealed interface HomeDirections {
    object ToDetails : HomeDirections
    object Back : HomeDirections
}