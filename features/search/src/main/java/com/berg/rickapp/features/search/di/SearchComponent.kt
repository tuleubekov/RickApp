package com.berg.rickapp.features.search.di

import com.berg.rickapp.core.presentation.di.AppViewModelFactory
import com.berg.rickapp.core.di.ComponentStorage
import com.berg.rickapp.features.search.api.SearchFeatureApi
import dagger.Component

@Component(
    modules = [SearchFeatureModule::class],
    dependencies = [SearchFeatureDependencies::class]
)
interface SearchComponent : SearchFeatureApi {

    fun getViewModelFactory(): AppViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: SearchFeatureDependencies): SearchComponent
    }

    companion object {

        fun init(dep: SearchFeatureDependencies) {
//            ComponentStorage.getOrCreate(SearchComponent::class) {
//                SearchDaggerComponent.factory().create(getSearchDependencies())
//            }
        }

        fun get() = ComponentStorage.getOrCreate(SearchComponent::class) {
            DaggerSearchComponent.factory().create(getSearchDependencies())
        }

        fun destroy() = ComponentStorage.remove(SearchComponent::class)
    }
}

fun Any.getSearchDependencies(): SearchFeatureDependencies =
    ComponentStorage.get(SearchFeatureDependencies::class)