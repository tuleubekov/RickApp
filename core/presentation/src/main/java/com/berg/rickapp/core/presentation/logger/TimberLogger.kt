package com.berg.rickapp.core.presentation.logger

import com.berg.rickapp.core.common.Logger
import timber.log.Timber

class TimberLogger : Logger {
    override fun initDebug() = Timber.plant(Timber.DebugTree())
    override fun d(message: String) = Timber.d(message)
    override fun e(message: String) = Timber.e(message)
}