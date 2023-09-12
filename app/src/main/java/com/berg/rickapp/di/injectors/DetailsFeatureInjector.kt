package com.berg.rickapp.di.injectors

import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.features.details.di.DetailsComponent
import com.berg.rickapp.features.details.di.DetailsFeatureDependencies
import javax.inject.Inject

class DetailsFeatureInjector @Inject constructor(
    private val detailsFeatureDependencies: DetailsFeatureDependencies,
) : Injector {

    override fun initComponent() {
        //
        DetailsComponent.init(detailsFeatureDependencies)
    }
}