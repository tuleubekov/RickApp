package com.berg.rickapp.features.search.di

import androidx.fragment.app.Fragment
import com.berg.rickapp.core.presentation.di.FragmentKey
import com.berg.rickapp.features.search.SearchFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class SearchFeatureFragmentModule {

    @IntoMap
    @Provides
    @FragmentKey(SearchFragment::class)
    fun provideSearchFragment(dependencies: SearchFeatureDependencies): Fragment {
        SearchComponent.init(dependencies)
        return SearchFragment()
    }
}