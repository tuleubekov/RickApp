package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.core.navigation.api.router.HomeRouter
import com.berg.rickapp.core.navigation.api.router.SplashRouter
import com.berg.rickapp.core.navigation.impl.routers.HomeRouterImpl
import com.berg.rickapp.core.navigation.impl.routers.SplashRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindHomeRouter(impl: HomeRouterImpl): HomeRouter

    @Binds
    fun bindSplashRouter(impl: SplashRouterImpl): SplashRouter

}