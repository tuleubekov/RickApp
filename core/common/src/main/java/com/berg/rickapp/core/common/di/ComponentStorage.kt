package com.berg.rickapp.core.common.di

import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
object ComponentStorage {

    private val map: MutableMap<KClass<out Any>, Any> = mutableMapOf()

    fun <T : Any> getOrCreate(clazz: KClass<T>, create: () -> T): T {
        var component = map[clazz]
        if (component == null) {
            component = create()
            map[clazz] = component
        }
        return component as T
    }

    fun create(clazz: KClass<out Any>, create: () -> Any) {
        map[clazz] = create()
    }

    fun <T : Any> get(clazz: KClass<T>): T =
        (map[clazz] ?: error("Not found instance of class: $clazz")) as T

    fun remove(clazz: KClass<out Any>) {
        map.remove(clazz)
    }

}