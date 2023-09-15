package com.berg.rickapp.di

import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.navigation.impl.di.NavigationModule
import com.berg.rickapp.core.presentation.base.AppFragmentFactory
import com.berg.rickapp.data.di.DataModule
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.domain.di.DomainModule
import com.berg.rickapp.features.details.di.DetailsFeatureFragmentModule
import com.berg.rickapp.features.home.di.HomeFeatureFragmentModule
import com.berg.rickapp.features.search.di.SearchFeatureFragmentModule
import com.berg.rickapp.features.splash.di.SplashFeatureFragmentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    NavigationModule::class,
    DataModule::class,
    DomainModule::class,
    FeatureDependenciesModule::class,
    FragmentFactoryModule::class,
    SplashFeatureFragmentModule::class,
    HomeFeatureFragmentModule::class,
    SearchFeatureFragmentModule::class,
    DetailsFeatureFragmentModule::class,
])
interface AppComponent {
    fun getFragmentFactory(): AppFragmentFactory

    companion object {
        fun init() = ComponentStorage.create(AppComponent::class) { DaggerAppComponent.create() }
        fun get() = ComponentStorage.get(AppComponent::class)
    }
}