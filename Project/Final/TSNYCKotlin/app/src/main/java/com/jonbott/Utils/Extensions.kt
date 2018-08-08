package com.jonbott.Utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*

val Int.isEven: Boolean
    get() = this % 2 == 0

fun Disposable.disposedBy(bag: CompositeDisposable) {
    bag.add(this)
}

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start