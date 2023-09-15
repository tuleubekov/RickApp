package com.berg.rickapp.features.splash.di

import androidx.fragment.app.Fragment
import com.berg.rickapp.core.presentation.di.FragmentKey
import com.berg.rickapp.features.splash.SplashFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class SplashFeatureFragmentModule {

    @IntoMap
    @Provides
    @FragmentKey(SplashFragment::class)
    fun provideSplashFragment(dependencies: SplashFeatureDependencies): Fragment {
        SplashComponent.init(dependencies)
        return SplashFragment()
    }
}