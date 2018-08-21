package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

class ClashingClass {
    fun someMethod() { println("internal method") }
}

fun ClashingClass.someMethod() { println("This will never be called") }

fun ClashingClass.someMethod(index: Int) { println("This method can be called") }