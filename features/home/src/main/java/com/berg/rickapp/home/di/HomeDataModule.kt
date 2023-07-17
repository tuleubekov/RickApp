package com.berg.rickapp.home.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.presentation.di.ViewModelKey
import com.berg.rickapp.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeDataModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindViewModel(homeViewModel: HomeViewModel): ViewModel
}