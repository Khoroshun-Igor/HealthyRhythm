package com.tamago.healthyrhythm.data.managers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.tamago.healthyrhythm.data.repositories.auth.AuthRepository
import com.tamago.healthyrhythm.data.repositories.auth.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 13.12.2023.
 */
class AuthManager @Inject constructor(private val repository: AuthRepository)
    : ViewModel() {
    private val _signInFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signInFlow: StateFlow<Resource<FirebaseUser>?> = _signInFlow

    private val _signUpFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signUpFlow: StateFlow<Resource<FirebaseUser>?> = _signUpFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if(repository.currentUser != null){
            _signInFlow.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun signIn(email: String, password: String) = viewModelScope.launch {
        _signInFlow.value = Resource.Loading
        val result = repository.signInWithEmailAndPassword(email, password)
        _signInFlow.value = result
    }

    fun signUp(name: String, email: String, password: String) = viewModelScope.launch {
        _signUpFlow.value = Resource.Loading
        val result = repository.signUpWithEmailAndPassword(name, email, password)
        _signUpFlow.value = result
    }

    fun signOut(){
        repository.logOut()
        _signInFlow.value = null
        _signUpFlow.value = null
    }

    fun resetEmail(email: String) = viewModelScope.launch{
        repository.sendPasswordResetEmail(email)
    }
}