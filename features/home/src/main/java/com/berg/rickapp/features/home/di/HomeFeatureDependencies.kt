package com.berg.rickapp.features.home.di

import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.features.home.nav.HomeDirections

interface HomeFeatureDependencies {
    fun getHomeInteractor(): HomeInteractor
    fun getHomeRouter(): NavigationApi<HomeDirections>
}