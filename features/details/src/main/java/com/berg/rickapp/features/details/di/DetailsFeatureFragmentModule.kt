package com.berg.rickapp.features.details.di

import androidx.fragment.app.Fragment
import com.berg.rickapp.core.presentation.di.FragmentKey
import com.berg.rickapp.features.details.DetailsFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class DetailsFeatureFragmentModule {

    @IntoMap
    @Provides
    @FragmentKey(DetailsFragment::class)
    fun provideDetailsFragment(dependencies: DetailsFeatureDependencies): Fragment {
        DetailsComponent.init(dependencies)
        return DetailsFragment()
    }
}