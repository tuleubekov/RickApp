package com.berg.rickapp.features.splash.di

import com.berg.rickapp.core.navigation.api.router.SplashRouter

interface SplashFeatureDependencies {
    fun getSplashRouter(): SplashRouter
}