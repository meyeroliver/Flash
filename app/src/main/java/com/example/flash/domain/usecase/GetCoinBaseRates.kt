package com.example.flash.domain.usecase

import com.example.flash.commons.Resource
import com.example.flash.data.remote.dto.CoinDetailDto
import com.example.flash.domain.repository.FixerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinBaseRates @Inject constructor(
    private val repository: FixerRepository
) {
    operator fun invoke(symbols: List<String>, base: String): Flow<Resource<CoinDetailDto>> = flow {
        try {
            emit(Resource.Loading<CoinDetailDto>())
            val currency = repository.getCoinBaseRates(symbols,base)
            println(currency)
            emit(Resource.Success<CoinDetailDto>(currency))
        }catch(e: HttpException) {
            emit(Resource.Error<CoinDetailDto>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetailDto>("Couldn't reach server. Check your internet connection."))
        }
    }
}