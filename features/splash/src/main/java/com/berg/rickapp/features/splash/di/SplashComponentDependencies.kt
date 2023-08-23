package com.berg.rickapp.features.splash.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.features.splash.router.SplashRouter

interface SplashComponentDependencies {
    fun getSplashRouter(): SplashRouter
}

fun Any.getSplashDependencies(): SplashComponentDependencies =
    ComponentStorage.get(BaseAppComponent::class) as SplashComponentDependencies