package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.details.di.DetailsComponent
import com.berg.rickapp.features.details.di.getDetailsDependencies
import com.berg.rickapp.features.home.router.HomeRouter
import javax.inject.Inject

class HomeRouterImpl @Inject constructor() : HomeRouter {

    override fun navigateToDetails(): NavigationEvent {
        DetailsComponent.init(getDetailsDependencies())
        return NavigationEvent.Forward(
            hostId = R.id.tabs_host_fragment,
            id = R.id.action_homeFragment_to_detailsFragment
        )
    }

    override fun navigateToAbout(): NavigationEvent {
        return NavigationEvent.Forward(
            hostId = R.id.root_nav_host,
            id = R.id.action_tabsFragment_to_aboutFragment
        )
    }
}