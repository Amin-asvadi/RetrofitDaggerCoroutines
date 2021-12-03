package com.devillas.daggerhiltandretrofit.di

import com.devillas.daggerhiltandretrofit.api.ImageService
import com.devillas.daggerhiltandretrofit.utile.Constance
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
    fun provideBaseUrl() =Constance.BASE_URL


    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL :String):ImageService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageService::class.java)


}