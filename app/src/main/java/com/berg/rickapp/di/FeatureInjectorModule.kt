package com.berg.rickapp.di

import com.berg.rickapp.core.di.FeatureInjector
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface FeatureInjectorModule {

    @Binds
    @Singleton
    fun bindFeatureInjectorModule(impl: FeatureInjectorImpl): FeatureInjector
}