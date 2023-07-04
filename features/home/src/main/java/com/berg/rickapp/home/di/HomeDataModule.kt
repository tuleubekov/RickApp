package com.berg.rickapp.home.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.di.ViewModelKey
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.HomeInteractorImpl
import com.berg.rickapp.data.HomeRepositoryImpl
import com.berg.rickapp.domain.repositories.HomeRepository
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

    @Binds
    fun provideHomeInteractor(homeInteractorImpl: HomeInteractorImpl): HomeInteractor

    @Binds
    fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}