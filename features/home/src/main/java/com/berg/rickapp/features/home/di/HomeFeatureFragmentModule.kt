package com.berg.rickapp.features.home.di

import androidx.fragment.app.Fragment
import com.berg.rickapp.core.presentation.di.FragmentKey
import com.berg.rickapp.features.home.HomeFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class HomeFeatureFragmentModule {

    @IntoMap
    @Provides
    @FragmentKey(HomeFragment::class)
    fun provideHomeFragment(dependencies: HomeFeatureDependencies): Fragment {
        HomeComponent.init(dependencies)
        return HomeFragment()
    }
}