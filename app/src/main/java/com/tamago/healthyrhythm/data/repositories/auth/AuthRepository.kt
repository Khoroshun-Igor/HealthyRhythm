package com.tamago.healthyrhythm.data.repositories.auth

import com.google.firebase.auth.FirebaseUser

/**
 * Created by Igor Khoroshun on 05.12.2023.
 */
interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun signUpWithEmailAndPassword(name: String, email: String, password: String): Resource<FirebaseUser>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Resource<FirebaseUser>
//    suspend fun signInWithGoogle
    suspend fun sendEmailVerification(): Resource<FirebaseUser>
    suspend fun sendPasswordResetEmail(email: String): Resource<FirebaseUser>
    fun logOut()

}