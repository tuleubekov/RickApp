package com.berg.rickapp.details.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.domain.repositories.HomeRepository

interface DetailsComponentDependencies {
    fun getCharactersRepository(): HomeRepository
}

fun Any.detailsDependencies(): DetailsComponentDependencies {
    return ComponentStorage.get(BaseAppComponent::class) as DetailsComponentDependencies
}