package com.backbase.android.cms.client.di

import com.backbase.android.cms.client.BuildConfig
import com.backbase.android.cms.client.data.repo.PostService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    val logging= HttpLoggingInterceptor()
    logging.level= HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(logging).build()
}

fun provideForecastApi(retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)
