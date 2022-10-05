package com.example.flash.data.remote.dto

data class CoinDetailDto(
    val base: String,
    val date: String,
    val ratesDto: RatesDto,
    val success: Boolean,
    val timestamp: Int
)
