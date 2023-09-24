package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.navigation.api.nav.NavigationEvent
import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.core.navigation.api.util.navApiR_id
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.splash.nav.SplashDirections
import javax.inject.Inject

class SplashDirectionsImpl @Inject constructor() : NavigationApi<SplashDirections> {

    override fun direct(direction: SplashDirections): NavigationEvent {
        return when (direction) {
            SplashDirections.ToTabs -> NavigationEvent.Forward(
                hostId = navApiR_id.root_nav_host,
                id = R.id.action_splashFragment_to_tabsFragment,
            )
        }
    }
}