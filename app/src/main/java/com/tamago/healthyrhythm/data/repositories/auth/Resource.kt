package com.tamago.healthyrhythm.data.repositories.auth

/**
 * Created by Igor Khoroshun on 05.12.2023.
 */
sealed class Resource<out R>{
    data class Success<out R>(val result: R): Resource<R>()
    data class Failure(val e: Exception): Resource<Nothing>()
    object Loading: Resource<Nothing>()
}
