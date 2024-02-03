package com.tamago.healthyrhythm.data.repositories.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 05.12.2023.
 */
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun signUpWithEmailAndPassword(
        name: String,
        email: String,
        password: String
    ): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resource.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<FirebaseUser> {
        return try{
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override suspend fun sendEmailVerification(): Resource<FirebaseUser> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordResetEmail(email: String): Resource<FirebaseUser> {
        TODO("Not yet implemented")
    }

    override fun logOut() {
        firebaseAuth.signOut()
    }
}