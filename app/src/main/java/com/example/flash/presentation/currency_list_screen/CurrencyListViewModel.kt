package com.example.flash.presentation.currency_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flash.commons.Constants
import com.example.flash.commons.Resource
import com.example.flash.domain.usecase.GetCoinBaseRates
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val getCoinBaseRates: GetCoinBaseRates,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state =  mutableStateOf(CurrencyListState())
    val state: State<CurrencyListState> = _state

    init {
        val symbols = savedStateHandle.get<List<String>>(Constants.SYMBOLS)
        val base = savedStateHandle.get<String>(Constants.BASE)
        if (symbols != null && base != null) {
            getCurrency(symbols,base)
        }
    }

    fun getCurrency(symbols: List<String>, base: String){
        getCoinBaseRates(symbols,base).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CurrencyListState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CurrencyListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CurrencyListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}