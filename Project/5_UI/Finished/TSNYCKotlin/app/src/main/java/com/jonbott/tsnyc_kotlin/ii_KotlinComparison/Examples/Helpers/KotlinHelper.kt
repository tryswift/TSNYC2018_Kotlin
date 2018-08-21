package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Helpers

class KotlinHelper(var isImportant: Boolean = true, var hasChanged: Boolean = false) {

    fun doSomething() {
        val stateString = if (isImportant) "Yes!" else "No..."
        println("Am I doing something important? $stateString")
    }
}

fun someGlobalMethod(name: String) {
    println("someGlobalMethod($name) called")
}