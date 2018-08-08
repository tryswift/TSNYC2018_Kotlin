package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Helpers.JavaHelper

object JavaFromKotlin {
    fun examples() {
        typeConversionExample()
        usingJavaClasses()
    }

    private fun typeConversionExample() {
        val list = ArrayList<String>() //non-null
            list.add("Item")

        val size = list.size //non-null (primitive int)
        val item = list[0]  //Java Object

        val nullable: String? = item
        val notNull: String = item //allowed, may fail at runtime

    }

    private fun usingJavaClasses() {
        val helper = JavaHelper()

        var username = "naruto uzumaki"
            username = helper.alterUsername(username)
        println("username: $username")
    }
}

/* -
In Kotlin, all exceptions are unchecked, meaning that the compiler does not force you to catch any of them.
So, when you call a Java method that declares a checked exception, Kotlin does not force you to do anything:
 */