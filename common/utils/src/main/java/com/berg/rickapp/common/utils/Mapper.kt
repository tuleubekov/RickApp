package com.berg.rickapp.common.utils

interface Mapper<T, R> {
    fun map(input: T): R
    fun map(input: List<T>): List<R> {
        return input.map { map(it) }
    }
}

interface BidirectionalMapper<T, R> : Mapper<T, R> {
    fun reverseMap(input: R): T
}