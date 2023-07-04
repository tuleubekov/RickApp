package com.berg.rickapp.home.di

import com.berg.rickapp.core.di.ScreenScope
import com.berg.rickapp.core.di.getComponent
import com.berg.rickapp.home.HomeFragment
import dagger.Component

@ScreenScope
@Component(dependencies = [HomeComponentDependencies::class], modules = [HomeDataModule::class])
interface HomeComponent {

    fun injectHomeFragment(fragmentHome: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeComponentDependencies): HomeComponent
    }

    companion object {

        private var homeComponent: HomeComponent? = null

        fun create() {
//            homeComponent = DaggerHomeComponent.builder().build()
        }

        fun destroy() {
            homeComponent = null
        }
    }
}

fun HomeFragment.inject() {
    getComponent {
        DaggerHomeComponent.factory().create(requireContext().homeDependencies())
    }.injectHomeFragment(this)
}