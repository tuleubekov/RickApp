package com.berg.rickapp.core.common

interface Logger {
    fun initDebug()
    fun e(message: String)
    fun d(message: String)
}