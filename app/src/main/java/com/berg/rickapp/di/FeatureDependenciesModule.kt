package com.berg.rickapp.di

import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.features.details.di.DetailsFeatureDependencies
import com.berg.rickapp.features.home.di.HomeFeatureDependencies
import com.berg.rickapp.features.home.router.HomeRouter
import com.berg.rickapp.features.search.api.SearchFeatureApi
import com.berg.rickapp.features.search.di.SearchComponent
import com.berg.rickapp.features.search.di.SearchFeatureDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeatureDependenciesModule {

    @Singleton
    @Provides
    fun provideHomeFeatureDependencies(
        homeInteractor: HomeInteractor,
        homeRouter: HomeRouter,
    ): HomeFeatureDependencies {
        return object : HomeFeatureDependencies {
            override fun getHomeInteractor(): HomeInteractor = homeInteractor
            override fun getHomeRouter(): HomeRouter = homeRouter
        }
    }

    @Singleton
    @Provides
    fun provideDetailsFeatureDependencies(
        homeInteractor: HomeInteractor,
    ): DetailsFeatureDependencies {
        return object : DetailsFeatureDependencies {
            override fun getHomeInteractor(): HomeInteractor = homeInteractor
        }
    }

    @Singleton
    @Provides
    fun provideSearchFeatureDependencies(
        homeInteractor: HomeInteractor,
    ): SearchFeatureDependencies {
        return object : SearchFeatureDependencies {
            override fun getHomeInteractor(): HomeInteractor = homeInteractor
        }
    }

    @Provides
    fun provideSearchFeatureApi(dependencies: SearchFeatureDependencies): SearchFeatureApi {
        SearchComponent.init(dependencies)
        return SearchComponent.get()
    }


}