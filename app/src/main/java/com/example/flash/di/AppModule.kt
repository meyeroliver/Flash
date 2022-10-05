package com.example.flash.di

import com.example.flash.commons.Constants
import com.example.flash.data.remote.api.FixerApi
import com.example.flash.data.repository.FixerRepositoryImpl
import com.example.flash.domain.repository.FixerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): FixerApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FixerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: FixerApi): FixerRepository {
        return FixerRepositoryImpl(api)
    }
}