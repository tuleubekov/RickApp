package com.berg.rickapp.navigation.impl.di

import com.berg.rickapp.home.navigation.HomeRouter
import com.berg.rickapp.navigation.impl.api.HomeRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindHomeRouter(impl: HomeRouterImpl): HomeRouter

}