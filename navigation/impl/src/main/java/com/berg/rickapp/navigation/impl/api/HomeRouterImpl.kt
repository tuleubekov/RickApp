package com.berg.rickapp.navigation.impl.api

import com.berg.rickapp.core.presentation.nav.NavigationEvent
import com.berg.rickapp.details.di.DetailsComponent
import com.berg.rickapp.details.di.getDetailsDependencies
import com.berg.rickapp.home.navigation.HomeRouter
import com.berg.rickapp.navigation.impl.R
import javax.inject.Inject

class HomeRouterImpl @Inject constructor() : HomeRouter {

    override fun navigateToDetails(): NavigationEvent {
        DetailsComponent.createAndRegister(getDetailsDependencies())
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