package com.berg.rickapp.features.details.di

import com.berg.rickapp.domain.HomeInteractor

interface DetailsFeatureDependencies {
    fun getHomeInteractor(): HomeInteractor
}