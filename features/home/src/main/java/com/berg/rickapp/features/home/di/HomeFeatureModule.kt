package com.berg.rickapp.features.home.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.presentation.di.ViewModelKey
import com.berg.rickapp.features.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeFeatureModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindViewModel(homeViewModel: HomeViewModel): ViewModel
}