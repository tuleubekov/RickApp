package com.berg.rickapp.navigation.api

import androidx.navigation.NavController
import com.berg.rickapp.R
import com.berg.rickapp.core.navigation.NavigationApi
import com.berg.rickapp.home.navigation.HomeDirections
import javax.inject.Inject

class HomeNavigationImpl @Inject constructor(
    private val navController: NavController,
): NavigationApi<HomeDirections> {

    override fun navigate(direction: HomeDirections) {
        when(direction) {
            HomeDirections.ToDetails -> {
                navController.navigate(R.id.action_homeFragment_to_detailsFragment)
            }
            HomeDirections.Back -> {
                navController.navigateUp()
            }
        }
    }
}