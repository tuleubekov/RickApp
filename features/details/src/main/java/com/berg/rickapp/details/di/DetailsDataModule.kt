package com.berg.rickapp.details.di

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.common.di.ScreenScope
import com.berg.rickapp.core.presentation.di.ViewModelKey
import com.berg.rickapp.details.DetailsViewModel
import com.berg.rickapp.domain.DetailsInteractor
import com.berg.rickapp.domain.DetailsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailsDataModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindsDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    @ScreenScope
    fun bindsDetailsInteractor(interactor: DetailsInteractorImpl): DetailsInteractor
}