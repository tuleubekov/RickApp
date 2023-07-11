package com.berg.rickapp.home.di

import android.content.Context
import com.berg.rickapp.data.api.RickApi

interface HomeComponentDependencies {
    fun getRickApi(): RickApi
}

fun Context.homeDependencies(): HomeComponentDependencies {
    return (applicationContext as HomeComponentDependenciesProvider)
        .getHomeComponentDependencies()
}