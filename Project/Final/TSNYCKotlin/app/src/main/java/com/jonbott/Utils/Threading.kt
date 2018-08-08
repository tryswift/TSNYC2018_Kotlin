package com.jonbott.kotlincomparison.Utilities

import android.os.Handler
import android.os.Looper
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

typealias Lambda<T> = () -> T
typealias VoidLambda<T> = (T) -> Unit

object Threading {

    fun dispatchMain(block: Lambda<Unit>) {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post {
            try {
                block()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun <T> async(task: Lambda<T>,
              finished: VoidLambda<T>? = null,
               onError: VoidLambda<Throwable>? = null,
             scheduler: Scheduler = Schedulers.io()): Disposable
    {
        var finished = finished ?: { _ -> }
        var onError  = onError  ?: { _ -> }

        return Single.fromCallable(task)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(scheduler)
                .subscribe(finished, onError)
    }
}
