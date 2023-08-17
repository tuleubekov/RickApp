package com.berg.rickapp.features.details.di

import com.berg.rickapp.core.di.BaseAppComponent
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.domain.HomeInteractor

interface DetailsComponentDependencies {
    fun getHomeInteractor(): HomeInteractor
}

fun Any.getDetailsDependencies(): DetailsComponentDependencies {
    return ComponentStorage.get(BaseAppComponent::class) as DetailsComponentDependencies
}