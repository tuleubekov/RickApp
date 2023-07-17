package com.berg.rickapp.home.di

import com.berg.rickapp.core.common.di.BaseAppComponent
import com.berg.rickapp.core.common.di.ComponentStorage
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.navigation.api.NavigationApi
import com.berg.rickapp.home.navigation.HomeDirections

interface HomeComponentDependencies {
    fun getHomeInteractor(): HomeInteractor
    fun getNavigationApi(): NavigationApi<HomeDirections>
}

fun Any.getHomeDependencies(): HomeComponentDependencies {
    return ComponentStorage.get(BaseAppComponent::class) as HomeComponentDependencies
}