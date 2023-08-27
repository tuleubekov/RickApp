package com.berg.rickapp.core.di

interface FeatureInjector {
    fun <T> init(type: T)
}

sealed interface FeatureType {
    object Home: FeatureType
    object Details: FeatureType
}