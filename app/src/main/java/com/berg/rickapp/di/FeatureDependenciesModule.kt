package com.berg.rickapp.di

import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.features.details.di.DetailsFeatureDependencies
import com.berg.rickapp.features.home.di.HomeFeatureDependencies
import com.berg.rickapp.features.home.router.HomeRouter
import com.berg.rickapp.features.search.di.SearchFeatureDependencies
import com.berg.rickapp.features.splash.di.SplashFeatureDependencies
import com.berg.rickapp.features.splash.router.SplashRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeatureDependenciesModule {

    @Singleton
    @Provides
    fun provideSplashFeatureDependencies(
        splashRouter: SplashRouter,
    ): SplashFeatureDependencies {
        return object : SplashFeatureDependencies {
            override fun getSplashRouter(): SplashRouter = splashRouter
        }
    }

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

}