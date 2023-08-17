package com.berg.rickapp.common.utils

interface Mapper<T, R> {
    fun map(input: T): R
}

interface BidirectionalMapper<T, R> : Mapper<T, R> {
    fun reverseMap(input: R): T
}