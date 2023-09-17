package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.core.navigation.api.util.navApiR_id
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.splash.router.SplashRouter
import javax.inject.Inject

class SplashRouterImpl @Inject constructor() : SplashRouter {

    override fun navigateToTabsFragment(): NavigationEvent = NavigationEvent.Forward(
        hostId = navApiR_id.root_nav_host,
        id = R.id.action_splashFragment_to_tabsFragment,
    )
}