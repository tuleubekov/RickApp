package com.berg.rickapp.home.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.di.ScreenScope
import com.berg.rickapp.core.di.ViewModelKey
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.HomeInteractorImpl
import com.berg.rickapp.data.HomeRepositoryImpl
import com.berg.rickapp.data.datasource.RemoteDataSource
import com.berg.rickapp.data.datasource.RemoteDataSourceImpl
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
    @ScreenScope
    fun bindHomeInteractor(homeInteractorImpl: HomeInteractorImpl): HomeInteractor

    @Binds
    @ScreenScope
    fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @ScreenScope
    fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}