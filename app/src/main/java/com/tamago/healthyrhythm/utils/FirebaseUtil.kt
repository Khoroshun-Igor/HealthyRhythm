package com.tamago.healthyrhythm.utils

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

/**
 * Created by Igor Khoroshun on 06.12.2023.
 */

suspend fun <T> Task<T>.await(): T {
    return suspendCancellableCoroutine { cont ->
        addOnCompleteListener {
            if(it.exception != null){
                cont.resumeWithException(it.exception!!)
            }else{
                cont.resume(it.result, null)
            }
        }
    }
}