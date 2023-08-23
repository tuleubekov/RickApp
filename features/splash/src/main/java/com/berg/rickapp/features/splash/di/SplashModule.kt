package com.berg.rickapp.features.splash.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.di.ViewModelKey
import com.berg.rickapp.features.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindViewModel(splashViewModel: SplashViewModel): ViewModel
}