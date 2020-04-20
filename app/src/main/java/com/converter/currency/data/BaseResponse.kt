package com.converter.currency.data

data class BaseResponse(
    val base: String?,
    val date: String?,
    val rates: Map<String, Double>?
)