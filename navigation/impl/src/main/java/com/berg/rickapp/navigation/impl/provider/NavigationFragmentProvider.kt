package com.berg.rickapp.navigation.impl.provider

import androidx.navigation.NavController
import com.berg.rickapp.navigation.impl.TabsFragment

interface NavigationFragmentProvider {
    fun getNavigationFragment(): TabsFragment?

    fun getRootNavController(): NavController?
}