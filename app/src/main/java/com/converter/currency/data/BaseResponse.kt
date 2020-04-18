package com.converter.currency.data

data class RevolutBaseResponse(
    val base: String?,
    val date: String?,
    val rates: Map<String, Double>?
)