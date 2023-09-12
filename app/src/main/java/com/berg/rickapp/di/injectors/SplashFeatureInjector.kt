package com.berg.rickapp.di.injectors

import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.features.splash.di.SplashComponent
import com.berg.rickapp.features.splash.di.SplashFeatureDependencies
import javax.inject.Inject
import javax.inject.Named

class SplashFeatureInjector @Inject constructor(
    @Named("splash") private val dependencies: SplashFeatureDependencies,
) : Injector {

    override fun initComponent() {
        //SplashComponent.init(dependencies)
    }
}