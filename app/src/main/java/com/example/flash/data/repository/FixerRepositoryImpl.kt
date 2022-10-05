package com.example.flash.data.repository

import com.example.flash.data.remote.api.FixerApi
import com.example.flash.data.remote.dto.CoinDetailDto
import com.example.flash.domain.repository.FixerRepository
import javax.inject.Inject

class FixerRepositoryImpl @Inject constructor(
    private val api: FixerApi
):FixerRepository{
    override suspend fun getCoinBaseRates(symbols: List<String>, base: String): CoinDetailDto {
        return api.getCoinBaseRates(symbols, base)
    }
}

