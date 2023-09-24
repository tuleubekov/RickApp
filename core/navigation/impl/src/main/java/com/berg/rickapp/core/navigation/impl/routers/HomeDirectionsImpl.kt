package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.navigation.api.nav.NavigationEvent
import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.core.navigation.api.util.navApiR_id
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.home.nav.HomeDirections
import javax.inject.Inject

class HomeDirectionsImpl @Inject constructor() : NavigationApi<HomeDirections> {

    override fun direct(direction: HomeDirections): NavigationEvent = when (direction) {
        HomeDirections.ToDetails -> toDetailsDirection()
        HomeDirections.ToAbout -> toAboutDirection()
    }

    private fun toDetailsDirection() = NavigationEvent.Forward(
        hostId = navApiR_id.tabs_host_fragment,
        id = R.id.action_homeFragment_to_detailsFragment
    )

    private fun toAboutDirection() = NavigationEvent.Forward(
        hostId = navApiR_id.root_nav_host,
        id = R.id.action_tabsFragment_to_aboutFragment
    )
}