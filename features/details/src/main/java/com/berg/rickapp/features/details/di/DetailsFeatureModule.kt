package com.berg.rickapp.features.details.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.features.details.DetailsViewModel
import com.berg.rickapp.core.presentation.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailsFeatureModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindsDetailsViewModel(viewModel: DetailsViewModel): ViewModel
}