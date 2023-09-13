package com.berg.rickapp.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.berg.rickapp.core.presentation.base.AppFragmentFactory
import com.berg.rickapp.core.presentation.di.FragmentKey
import com.berg.rickapp.features.details.DetailsFragment
import com.berg.rickapp.features.details.di.DetailsComponent
import com.berg.rickapp.features.details.di.DetailsFeatureDependencies
import com.berg.rickapp.features.home.HomeFragment
import com.berg.rickapp.features.home.di.HomeComponent
import com.berg.rickapp.features.home.di.HomeFeatureDependencies
import com.berg.rickapp.features.search.SearchFragment
import com.berg.rickapp.features.search.di.SearchComponent
import com.berg.rickapp.features.search.di.SearchFeatureDependencies
import com.berg.rickapp.features.splash.SplashFragment
import com.berg.rickapp.features.splash.di.SplashComponent
import com.berg.rickapp.features.splash.di.SplashFeatureDependencies
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [FragmentBindingModule.FragmentFactoryModule::class])
class FragmentBindingModule {

    @IntoMap
    @Provides
    @FragmentKey(SplashFragment::class)
    fun provideSplashFragment(dependencies: SplashFeatureDependencies): Fragment {
        SplashComponent.init(dependencies)
        return SplashFragment()
    }

    @IntoMap
    @Provides
    @FragmentKey(HomeFragment::class)
    fun provideHomeFragment(dependencies: HomeFeatureDependencies): Fragment {
        HomeComponent.init(dependencies)
        return HomeFragment()
    }

    @IntoMap
    @Provides
    @FragmentKey(SearchFragment::class)
    fun provideSearchFragment(dependencies: SearchFeatureDependencies): Fragment {
        SearchComponent.init(dependencies)
        return SearchFragment()
    }

    @IntoMap
    @Provides
    @FragmentKey(DetailsFragment::class)
    fun provideDetailsFragment(dependencies: DetailsFeatureDependencies): Fragment {
        DetailsComponent.init(dependencies)
        return DetailsFragment()
    }

    @Module
    interface FragmentFactoryModule {
        @Binds
        fun bindFragmentFactory(factory: AppFragmentFactory): FragmentFactory
    }
}