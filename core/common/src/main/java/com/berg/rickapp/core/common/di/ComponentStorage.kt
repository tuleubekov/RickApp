package com.berg.rickapp.core.common.di

import kotlin.reflect.KClass

object ComponentStorage {

    private val map: MutableMap<KClass<out Any>, Any> = mutableMapOf()

    fun getOrCreate(clazz: KClass<out Any>, create: () -> Any): Any {
        var component = map[clazz]
        if (component == null) {
            component = create()
            map[clazz] = component
        }
        return component
    }

    fun create(clazz: KClass<out Any>, create: () -> Any): Any {
        val component = create()
        map[clazz] = component
        return component
    }

    fun get(clazz: KClass<out Any>): Any =
        map[clazz] ?: error("Not found instance of class: $clazz")

    fun remove(clazz: KClass<out Any>) {
        map.remove(clazz)
    }

}