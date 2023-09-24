package com.berg.rickapp.features.details.di

import com.berg.rickapp.core.presentation.factory.AppViewModelFactory
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.di.ScreenScope
import dagger.Component

@ScreenScope
@Component(
    dependencies = [DetailsFeatureDependencies::class],
    modules = [DetailsFeatureModule::class]
)
interface DetailsComponent {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: DetailsFeatureDependencies): DetailsComponent
    }

    companion object {

        fun init(dep: DetailsFeatureDependencies) = ComponentStorage.create(DetailsComponent::class) {
            DaggerDetailsComponent.factory().create(dep)
        }

        fun get(): DetailsComponent = ComponentStorage.get(DetailsComponent::class)

        fun destroy() = ComponentStorage.remove(DetailsComponent::class)
    }
}