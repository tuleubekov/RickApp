package com.berg.rickapp.core.navigation.impl.routers

import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.core.navigation.impl.R
import com.berg.rickapp.features.splash.router.SplashRouter
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class SplashRouterImpl @Inject constructor(
    @Named("home") private val injector: Provider<Injector>,
) : SplashRouter {

    override fun navigateToTabsFragment(): NavigationEvent {
        injector.get().initComponent()
        return NavigationEvent.Forward(
            hostId = R.id.root_nav_host,
            id = R.id.action_splashFragment_to_tabsFragment,
        )
    }
}