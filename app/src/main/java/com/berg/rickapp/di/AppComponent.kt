package com.berg.rickapp.di

import com.berg.rickapp.data.datasource.RemoteDataSource
import com.berg.rickapp.data.di.NetworkModule
import com.berg.rickapp.home.di.HomeComponentDependencies
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent : HomeComponentDependencies {

    override fun getRemoteDataSource(): RemoteDataSource

}