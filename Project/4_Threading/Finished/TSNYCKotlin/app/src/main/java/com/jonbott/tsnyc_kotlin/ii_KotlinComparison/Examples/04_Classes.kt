package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

//region Basic Class constructor

class Person constructor(firstName: String)

//endregion

//region Property declaration in class header

class Person2(val firstName: String, val lastName: String, var age: Int)

//endregion

//region Init Blocks

class Customer(name: String) {
    init {
        println("Customer initialized with value $name")
    }
}

//endregion

//region Header constructor arguments

class Customer2(name: String) {
    val customerKey = name.toUpperCase()
}

//endregion

//region Secondary constructor only

class Person4 {
    var children = mutableListOf<Person4>()

    constructor(parent: Person4) {
        parent.children.add(this)
    }
}

//endregion

//region secondary constructor with class header

class Person3(val name: String) {
    var children = mutableListOf<Person3>()

    constructor(name: String, parent: Person3) : this(name) {
        parent.children.add(this)
    }
}

//endregion

//region Static Members

class MyStaticClass {
    companion object {
        var someClassLevelVar = 13
        fun someClassLevelMethod(someArg: Int) = println("someClassLevelMethod($someArg)")
    }
}

//endregion

//region Examples

//Singleton
object Classes {
    fun example1() {
        //New Instance
        var person = Person("Naruto Uzumaki")

        //Static Class
        val someClassLevelVar = MyStaticClass.someClassLevelVar
        MyStaticClass.someClassLevelMethod(someClassLevelVar)
    }
}

//endregion

//region Data Classes

/*
Why use?  Automatic generation of better methods:
equals()
hashCode()
toString()  "User(name=John, age=42)"
copy()
etc.
*/

data class User(val name: String, val age: Int)

//endregion