package com.example.flash.domain.repository

import com.example.flash.data.remote.dto.CoinDetailDto

interface FixerRepository {
    suspend fun getCoinBaseRates(symbols: List<String>, base: String): CoinDetailDto
}
