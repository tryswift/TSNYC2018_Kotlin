package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

interface NetworkInteractor {
    val timeoutValue: Int // abstract - must be implemented

    val mimetype: String
        get() = "application/json" //can be overridden

    fun makeRequest() { //default implementation
        println("timeoutValue: $timeoutValue")
    }

    fun parseRequest()
}

class NetworkInteraction() : NetworkInteractor {
    override val timeoutValue: Int = 29

    override fun parseRequest() {

    }
}

object Interfaces {
    fun basics() {
        //should normally inject this
        val network: NetworkInteractor = NetworkInteraction()

        println("network.mimetype: " + network.mimetype)
        network.makeRequest()
    }
}

