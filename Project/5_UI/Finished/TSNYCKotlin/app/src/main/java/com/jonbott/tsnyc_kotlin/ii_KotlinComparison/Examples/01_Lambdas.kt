package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

import com.jonbott.kotlincomparison.Utilities.Threading

object Lambdas {
    fun asyncNetworkCall(finished: (Boolean)->Unit) {
        Threading.async(task = {
            println("asyncNetworkCall starting...")
            Thread.sleep(2000)
            println("asyncNetworkCall finished")

            finished(true)
        })
    }

    fun localDBCall(authenticationBlock: (String)->Boolean) {
        //do some local work
        val userName = "Naruto Uzumaki"
        val isAuthorized = authenticationBlock(userName)
        useLocalResult(userName, isAuthorized)
    }

    private fun useLocalResult(userName: String, isAuthorized: Boolean) {
        println("$userName is authorized: $isAuthorized")
    }
}