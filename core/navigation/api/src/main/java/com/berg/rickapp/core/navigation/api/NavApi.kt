package com.berg.rickapp.core.navigation.api

import com.berg.rickapp.core.navigation.api.router.HomeRouter
import com.berg.rickapp.core.navigation.api.router.SplashRouter

interface NavApi {
    fun getSplashRouter(): SplashRouter
    fun getHomeRouter(): HomeRouter
}