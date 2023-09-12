package com.berg.rickapp.di

import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.di.injectors.DetailsFeatureInjector
import com.berg.rickapp.di.injectors.HomeFeatureInjector
import com.berg.rickapp.di.injectors.SplashFeatureInjector
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
interface FeatureInjectorModule {

    @Binds
    @Singleton
    @Named("splash")
    fun bindSplashInjector(impl: SplashFeatureInjector): Injector

    @Binds
    @Singleton
    @Named("home")
    fun bindHomeInjector(impl: HomeFeatureInjector): Injector

    @Binds
    @Singleton
    @Named("details")
    fun bindDetailsInjector(impl: DetailsFeatureInjector): Injector
}