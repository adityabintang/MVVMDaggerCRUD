package com.bintang.mvvmdaggercrud.network

import com.bintang.mvvmdaggercrud.BuildConfig
import com.bintang.mvvmdaggercrud.constant.Constant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ConfigNetwork {

    @Provides
    @Singleton
    fun providesHttpLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = when(BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    @Singleton
    fun provideInterceptor(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(interceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit {
       var constant : Constant
       constant = Constant()
        return Retrofit.Builder().apply {
            client(client)
            baseUrl(constant.URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }


}