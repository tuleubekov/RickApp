package com.berg.rickapp.di

object AppComponentInjector {
    private lateinit var _appComponent: AppComponent
    val appComponent get() = _appComponent

    fun create(): AppComponent {
        val appComponent = DaggerAppComponent.create()
        _appComponent = appComponent
        return appComponent
    }
}

val Any.Injector: AppComponent by lazy { AppComponentInjector.appComponent }