package com.example.flash.data.remote.api

import com.example.flash.data.remote.dto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FixerApi {
    @Headers( "apikey : f4OF5sDpxIrKlr9e57cnH22PVAz4KlQ5")
    @GET("/fixer/latest?symbols={symbols}&base={base}")
    suspend fun getCoinBaseRates(@Query("symbols") symbols: List<String>, @Query("base") base: String): CoinDetailDto
}