package com.tamago.healthyrhythm.di

import com.google.firebase.auth.FirebaseAuth
import com.tamago.healthyrhythm.data.repositories.auth.AuthRepository
import com.tamago.healthyrhythm.data.repositories.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
}