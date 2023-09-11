package com.berg.rickapp.features.search.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.di.ViewModelKey
import com.berg.rickapp.features.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchFeatureModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindViewModel(impl: SearchViewModel): ViewModel
}