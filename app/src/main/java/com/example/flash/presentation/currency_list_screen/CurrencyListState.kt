package com.example.flash.presentation.currency_list_screen

import com.example.flash.data.remote.dto.CoinDetailDto

data class CurrencyListState(
    val isLoading: Boolean = false,
    val coin: CoinDetailDto? = null,
    val error: String =""
)
