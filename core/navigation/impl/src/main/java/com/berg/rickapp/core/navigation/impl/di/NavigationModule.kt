package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.features.home.router.HomeRouter
import com.berg.rickapp.core.navigation.impl.routers.HomeRouterImpl
import com.berg.rickapp.core.navigation.impl.routers.SplashRouterImpl
import com.berg.rickapp.features.splash.router.SplashRouter
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindHomeRouter(impl: HomeRouterImpl): HomeRouter

    @Binds
    fun bindSplashRouter(impl: SplashRouterImpl): SplashRouter

}