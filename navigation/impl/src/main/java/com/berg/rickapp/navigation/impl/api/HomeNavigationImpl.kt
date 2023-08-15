package com.berg.rickapp.navigation.impl.api

import androidx.navigation.NavController
import com.berg.rickapp.navigation.api.NavigationApi
import com.berg.rickapp.home.navigation.HomeDirections
import com.berg.rickapp.navigation.impl.R
import javax.inject.Inject

class HomeNavigationImpl @Inject constructor(
    private val navController: NavController,
): NavigationApi<HomeDirections> {

    override fun navigate(direction: HomeDirections) {
        when(direction) {
            HomeDirections.ToDetails -> {
                navController.navigate(R.id.action_homeFragment_to_detailsFragment)
            }
            HomeDirections.ToAbout -> {
                //--
            }
            HomeDirections.Back -> {
                navController.navigateUp()
            }
        }
    }
}