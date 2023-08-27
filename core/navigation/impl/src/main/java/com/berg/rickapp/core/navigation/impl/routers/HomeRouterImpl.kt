package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.home.router.HomeRouter
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class HomeRouterImpl @Inject constructor(
    @Named("details") private val injector: Provider<Injector>,
) : HomeRouter {

    override fun navigateToDetails(): NavigationEvent {
        injector.get().initComponent()
        return NavigationEvent.Forward(
            hostId = R.id.tabs_host_fragment,
            id = R.id.action_homeFragment_to_detailsFragment
        )
    }

    override fun navigateToAbout() = NavigationEvent.Forward(
        hostId = R.id.root_nav_host,
        id = R.id.action_tabsFragment_to_aboutFragment
    )
}