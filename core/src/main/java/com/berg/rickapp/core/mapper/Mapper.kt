package com.berg.rickapp.core.mapper

interface Mapper<T, R> {
    fun map(input: T): R
}

interface BidirectionalMapper<T, R> : Mapper<T, R> {
    fun reverseMap(input: R): T
}