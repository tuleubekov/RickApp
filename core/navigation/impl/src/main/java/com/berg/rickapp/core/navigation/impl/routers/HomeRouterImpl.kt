package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.navigation.api.nav.NavigationEvent
import com.berg.rickapp.core.navigation.api.router.HomeRouter
import com.berg.rickapp.core.navigation.api.util.navApiR_id
import com.berg.rickapp.core.navigation.impl.R
import javax.inject.Inject

class HomeRouterImpl @Inject constructor() : HomeRouter {

    override fun navigateToDetails(): NavigationEvent = NavigationEvent.Forward(
        hostId = navApiR_id.tabs_host_fragment,
        id = R.id.action_homeFragment_to_detailsFragment
    )

    override fun navigateToAbout() = NavigationEvent.Forward(
        hostId = navApiR_id.root_nav_host,
        id = R.id.action_tabsFragment_to_aboutFragment
    )
}