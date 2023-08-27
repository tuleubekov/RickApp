package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.di.FeatureInjector
import com.berg.rickapp.core.di.FeatureType
import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.splash.router.SplashRouter
import javax.inject.Inject
import javax.inject.Provider

class SplashRouterImpl @Inject constructor(
    private val injector: Provider<FeatureInjector>,
) : SplashRouter {

    override fun navigateToTabsFragment(): NavigationEvent {
        injector.get().init(FeatureType.Home)
        return NavigationEvent.Forward(
            hostId = R.id.root_nav_host,
            id = R.id.action_splashFragment_to_tabsFragment,
        )
    }
}