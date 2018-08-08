package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

//region Generic Types

class Box<T>(t: T) {
    var value = t
}

//endregion

//region Generic Functions

fun <T> singletonList(item: T): List<T> {
    return listOf()
}

fun <T> T.basicToString() : String { //extension function
    return ""
}

//endregion

//region Upper Bounds

fun <T: Comparable<T>> sort(list: List<T>) {
    //...
}

//endregion

object Generics {
    fun basicGenerics() {
        val box: Box<Int> = Box<Int>(1)
        val box2 = Box(1)
        val box3 = Box(2.3)
    }

    fun functionGenerics() {
        val l = singletonList<Int>(1)
        val l2 = singletonList(1)
    }
}