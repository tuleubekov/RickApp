package com.berg.rickapp.navigation.impl.provider

import com.berg.rickapp.navigation.impl.MainFragment

interface NavigationFragmentProvider {
    fun getNavigationFragment(): MainFragment?
}