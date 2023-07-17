package com.berg.rickapp.navigation

import com.berg.rickapp.presentation.MainFragment

interface NavigationFragmentProvider {
    fun getNavigationFragment(): MainFragment?
}