package com.backbase.android.cms.client.di

import com.backbase.android.cms.client.BuildConfig
import com.backbase.android.cms.client.data.repo.PostService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This Module is part of Koin Dependencies it refers to setup the http client
 */
val networkModule: Module = module {
    factory { provideOkHttpClient() }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

/**
 * Creating a Retrofit client
 */
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

/**
 * Creating an OkHttpClient client
 */
fun provideOkHttpClient(): OkHttpClient {
    val logging= HttpLoggingInterceptor()
    logging.level= HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(logging).build()
}
/**
 * Creating the PostService that is used to fetch the data
 */
fun provideForecastApi(retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)
