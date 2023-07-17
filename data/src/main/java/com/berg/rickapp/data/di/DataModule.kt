package com.berg.rickapp.data.di

import com.berg.rickapp.data.HomeRepositoryImpl
import com.berg.rickapp.data.datasource.RemoteDataSource
import com.berg.rickapp.data.datasource.RemoteDataSourceImpl
import com.berg.rickapp.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    fun bindRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource
}