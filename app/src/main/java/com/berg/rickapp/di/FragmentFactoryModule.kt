package com.berg.rickapp.di

import androidx.fragment.app.FragmentFactory
import com.berg.rickapp.core.presentation.base.AppFragmentFactory
import dagger.Binds
import dagger.Module

@Module
interface FragmentFactoryModule {
    @Binds
    fun bindFragmentFactory(factory: AppFragmentFactory): FragmentFactory
}