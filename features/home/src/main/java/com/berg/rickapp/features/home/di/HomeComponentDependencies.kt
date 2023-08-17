package com.berg.rickapp.features.home.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.features.home.router.HomeRouter

interface HomeComponentDependencies {
    fun getHomeInteractor(): HomeInteractor
    fun getRouter(): HomeRouter
}

fun Any.getHomeDependencies(): HomeComponentDependencies {
    return ComponentStorage.get(BaseAppComponent::class) as HomeComponentDependencies
}