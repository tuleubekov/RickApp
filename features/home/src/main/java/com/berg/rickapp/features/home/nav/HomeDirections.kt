package com.berg.rickapp.features.home.nav

sealed interface HomeDirections {
    object ToDetails : HomeDirections
    object ToAbout : HomeDirections
}