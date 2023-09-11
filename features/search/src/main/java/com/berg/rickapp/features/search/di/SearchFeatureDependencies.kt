package com.berg.rickapp.features.search.di

import com.berg.rickapp.domain.HomeInteractor

interface SearchFeatureDependencies {
    fun getHomeInteractor(): HomeInteractor
}