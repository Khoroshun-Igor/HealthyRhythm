package com.tamago.healthyrhythm.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tamago.healthyrhythm.data.repositories.auth.AuthRepository
import com.tamago.healthyrhythm.data.repositories.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by Igor Khoroshun on 05.12.2023.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    @Named("OkHttp")
    fun provideOkHttp(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Named("Retrofit")
    fun provideRetrofit(@Named("OkHttp") okHttpClient: OkHttpClient): Retrofit {
        val baseUrl = "https://api.openweathermap.org/data/2.5/"
        val converterFactory = Json.asConverterFactory("application/json".toMediaType())
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

//    @Provides
//    fun provideWeatherService(@Named("Retrofit") retrofit: Retrofit): WeatherService{
//        return retrofit.create(WeatherService::class.java)
//    }

//    @Provides
//    fun provideWeatherRepository(service: WeatherService): WeatherRepository {
//        return WeatherRepositoryImpl(service)
//    }

//    @Provides
//    fun provideWeather(): WeatherService{
//        val baseUrl = "https://api.openweathermap.org/data/2.5/"
//        val json = Json
//        val contentType = "application/json".toMediaType()
//        val httpClient = OkHttpClient.Builder()
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .build()
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(json.asConverterFactory(contentType))
//            .baseUrl(baseUrl)
//            .client(httpClient)
//            .build()
//        return retrofit.create()
//    }
}