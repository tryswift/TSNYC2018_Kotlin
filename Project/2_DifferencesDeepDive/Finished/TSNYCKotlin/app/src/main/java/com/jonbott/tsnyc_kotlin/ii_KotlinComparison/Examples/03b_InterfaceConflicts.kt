package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

interface DatabaseInteractor {
    fun loadFamily() { println("A") }
    fun loadFriends()
}

interface DatabaseHelper {
    fun loadFamily() { println("loading family") }
    fun loadFriends() { println("loading all friends") }
}

class SimpleDatebaseInteraction: DatabaseInteractor {
    override fun loadFriends() {
        println("loading friends I care about")
    }
}

class ComplexDatabaseInteraction: DatabaseInteractor, DatabaseHelper {
    override fun loadFamily() {
        //possible to use both default implementations
        super<DatabaseInteractor>.loadFamily()
        super<DatabaseHelper>.loadFamily()
    }

    override fun loadFriends() {
        super<DatabaseHelper>.loadFriends()
    }
}

fun Interfaces.multipleInterfaces() {
    var database: DatabaseInteractor = ComplexDatabaseInteraction()

    database.loadFamily()
    database.loadFriends()
}