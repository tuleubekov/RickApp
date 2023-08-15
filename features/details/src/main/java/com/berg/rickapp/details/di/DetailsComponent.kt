package com.berg.rickapp.details.di

import com.berg.rickapp.core.presentation.di.AppViewModelFactory
import com.berg.rickapp.core.common.di.ComponentStorage
import com.berg.rickapp.core.common.di.ScreenScope
import dagger.Component

@ScreenScope
@Component(dependencies = [DetailsComponentDependencies::class], modules = [DetailsDataModule::class])
interface DetailsComponent {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: DetailsComponentDependencies): DetailsComponent
    }

    companion object {

        fun init(dependencies: DetailsComponentDependencies) =
            ComponentStorage.create(DetailsComponent::class) {
                DaggerDetailsComponent.factory().create(dependencies)
            }

        fun get(): DetailsComponent = ComponentStorage.get(DetailsComponent::class)

        fun destroy() = ComponentStorage.remove(DetailsComponent::class)
    }
}