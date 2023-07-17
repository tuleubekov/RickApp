package com.berg.rickapp.domain.di

import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.HomeInteractorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DomainModule {

    @Binds
    @Singleton
    fun bindHomeInteractor(homeInteractorImpl: HomeInteractorImpl): HomeInteractor

}