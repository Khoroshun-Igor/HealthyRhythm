plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.tamago.healthyrhythm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tamago.healthyrhythm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val lottieVersion = "6.3.0"
val daggerVersion = "2.50"
val coreKtxVersion = "1.12.0"
val ktxRuntimeVersion = "2.7.0"
val navigationVersion = "2.7.7"
val hiltNavigationVersion = "1.1.0"
val firebaseAnalyticsVersion = "21.5.1"
val firebaseAuthVersion = "22.3.1"
val firebaseFirestormVersion = "24.10.2"
val junitVersion = "4.13.2"
val activityComposeVersion = "1.8.2"
val lifecycleComposeVersion = "2.7.0"
val material3Version = "1.2.0"
val retrofit2ConverterVersion = "1.0.0"
val retrofitVersion = "2.9.0"
val coilVersion = "2.5.0"
val serializationJsonVersion = "1.6.2"

dependencies {

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$ktxRuntimeVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleComposeVersion")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("androidx.navigation:navigation-runtime-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-compose:$navigationVersion")
    implementation("com.google.firebase:firebase-analytics:$firebaseAnalyticsVersion")
    implementation("com.google.firebase:firebase-auth:$firebaseAuthVersion")
    implementation("com.google.firebase:firebase-firestore:$firebaseFirestormVersion")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofit2ConverterVersion")
    implementation("io.coil-kt:coil-compose:$coilVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationJsonVersion")
    implementation ("com.airbnb.android:lottie-compose:$lottieVersion")
    //OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    //dagger
    implementation ("com.google.dagger:dagger:$daggerVersion")
    implementation("com.google.dagger:hilt-android:$daggerVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationVersion")

    implementation ("com.airbnb.android:lottie:$lottieVersion")
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.1")

}
kapt {
    correctErrorTypes = true
}