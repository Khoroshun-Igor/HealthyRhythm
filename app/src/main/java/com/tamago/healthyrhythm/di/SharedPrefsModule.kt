package com.tamago.healthyrhythm.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.tamago.healthyrhythm.app.Constants
import com.tamago.healthyrhythm.data.sharedprefs.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */
@Module
@InstallIn(SingletonComponent::class)
class SharedPrefsModule {
    @Provides
    @Singleton
    fun providesSharedPrefs(@ApplicationContext appContext: Context): SharedPrefs =
        SharedPrefs(appContext.getSharedPreferences(Constants.APP_SHARED_PREFS, MODE_PRIVATE))
}