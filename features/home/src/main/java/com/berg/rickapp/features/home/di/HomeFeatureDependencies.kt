package com.berg.rickapp.features.home.di

import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.core.navigation.api.router.HomeRouter

interface HomeFeatureDependencies {
    fun getHomeInteractor(): HomeInteractor
    fun getHomeRouter(): HomeRouter
}