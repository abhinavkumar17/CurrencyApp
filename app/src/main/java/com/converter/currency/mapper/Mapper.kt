package com.converter.currency.mapper

interface Mapper<E, D> {
    fun mapToEntity(response: E): D
}