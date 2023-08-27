package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.di.FeatureInjector
import com.berg.rickapp.core.di.FeatureType
import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.home.router.HomeRouter
import javax.inject.Inject
import javax.inject.Provider

class HomeRouterImpl @Inject constructor(
    private val injector: Provider<FeatureInjector>,
) : HomeRouter {

    override fun navigateToDetails(): NavigationEvent {
        injector.get().init(FeatureType.Details)
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