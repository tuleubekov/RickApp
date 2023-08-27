package com.berg.rickapp.di

import com.berg.rickapp.core.di.FeatureInjector
import com.berg.rickapp.core.di.FeatureType
import com.berg.rickapp.features.details.di.DetailsComponent
import com.berg.rickapp.features.details.di.DetailsFeatureDependencies
import com.berg.rickapp.features.home.di.HomeComponent
import com.berg.rickapp.features.home.di.HomeFeatureDependencies
import javax.inject.Inject

class FeatureInjectorImpl @Inject constructor(
    private val homeFeatureDependencies: HomeFeatureDependencies,
    private val detailsFeatureDependencies: DetailsFeatureDependencies,
) : FeatureInjector {

    override fun <T> init(type: T) {
        when(type) {
            FeatureType.Home -> HomeComponent.init(homeFeatureDependencies)
            FeatureType.Details -> DetailsComponent.init(detailsFeatureDependencies)
        }
    }
}