package com.berg.rickapp.details.di

import com.berg.rickapp.core.di.AppViewModelFactory
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.core.di.ScreenScope
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

        fun getOrCreate(): DetailsComponent {
            return ComponentStorage.getOrCreate(DetailsComponent::class) {
                DaggerDetailsComponent.factory().create(detailsDependencies())
            } as DetailsComponent
        }

        fun destroy() {
            ComponentStorage.destroy(DetailsComponent::class)
        }
    }
}