package com.berg.rickapp.features.splash.di

import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.features.splash.router.SplashRouter

interface SplashFeatureDependencies {
    fun getSplashRouter(): SplashRouter
}

fun Any.getSplashDependencies(): SplashFeatureDependencies =
    ComponentStorage.get(SplashFeatureDependencies::class)