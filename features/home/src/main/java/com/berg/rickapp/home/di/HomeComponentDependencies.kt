package com.berg.rickapp.home.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.navigation.NavigationApi
import com.berg.rickapp.domain.repositories.HomeRepository
import com.berg.rickapp.home.navigation.HomeDirections

interface HomeComponentDependencies {
    fun getCharactersRepository(): HomeRepository

    fun getNavigationApi(): NavigationApi<HomeDirections>
}

fun Any.homeDependencies(): HomeComponentDependencies {
    return ComponentStorage.get(BaseAppComponent::class) as HomeComponentDependencies
}