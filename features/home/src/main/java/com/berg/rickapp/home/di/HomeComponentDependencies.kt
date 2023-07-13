package com.berg.rickapp.home.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.domain.repositories.HomeRepository

interface HomeComponentDependencies {
    fun getCharactersRepository(): HomeRepository
}

fun Any.homeDependencies(): HomeComponentDependencies {
    return ComponentStorage.get(BaseAppComponent::class) as HomeComponentDependencies
}