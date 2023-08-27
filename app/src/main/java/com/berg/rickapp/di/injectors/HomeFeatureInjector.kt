package com.berg.rickapp.di.injectors

import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.features.home.di.HomeComponent
import com.berg.rickapp.features.home.di.HomeFeatureDependencies
import javax.inject.Inject

class HomeFeatureInjector @Inject constructor(
    private val homeFeatureDependencies: HomeFeatureDependencies,
) : Injector {

    override fun initComponent() {
        HomeComponent.init(homeFeatureDependencies)
    }
}