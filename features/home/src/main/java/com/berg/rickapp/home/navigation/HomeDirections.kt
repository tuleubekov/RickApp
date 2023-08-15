package com.berg.rickapp.home.navigation

sealed interface HomeDirections {
    object ToDetails : HomeDirections
    object ToAbout : HomeDirections
    object Back : HomeDirections
}