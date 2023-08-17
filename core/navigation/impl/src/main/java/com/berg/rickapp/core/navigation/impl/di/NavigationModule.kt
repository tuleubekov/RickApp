package com.berg.rickapp.core.navigation.impl.di

import com.berg.rickapp.features.home.router.HomeRouter
import com.berg.rickapp.core.navigation.impl.routers.HomeRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindHomeRouter(impl: HomeRouterImpl): HomeRouter

}