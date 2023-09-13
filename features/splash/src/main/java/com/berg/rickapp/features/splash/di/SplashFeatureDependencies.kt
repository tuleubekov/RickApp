package com.berg.rickapp.features.splash.di

import com.berg.rickapp.features.splash.router.SplashRouter

interface SplashFeatureDependencies {
    fun getSplashRouter(): SplashRouter
}