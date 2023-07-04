package com.berg.rickapp.home.di

import android.content.Context
import com.berg.rickapp.data.datasource.RemoteDataSource

interface HomeComponentDependencies {
    fun getRemoteDataSource(): RemoteDataSource
}

fun Context.homeDependencies(): HomeComponentDependencies {
    return (applicationContext as HomeComponentDependenciesProvider)
        .getHomeComponentDependencies()
}