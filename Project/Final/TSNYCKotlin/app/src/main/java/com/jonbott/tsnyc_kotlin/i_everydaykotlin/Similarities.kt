package com.jonbott.everydaykotlin

class Similarities {
    // -----------------------------------------------------------
    //region Functions

    fun showVariables(name: String, age: Int): String {
        return "Hello, world!"
    }

    /*
    func showVariables(name: String, age: Int) -> String {
        return "Hello, world!"
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Function Calls

    fun runExamples() {
        var result = showVariables(name = "Naruto", age = 35)

        var result2 = showVariables("Naruto", 35)
    }

    /*
    func runExamples() {
        var result = showVariables(name: "Naruto", age: 35)
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Variables

    fun showVariables(): String {
        var myVariable = 42
        myVariable = 50

        val myConstant = 42
        //myConstant = 33 //will not compile

        val explicitDouble: Double = 70.0

        return "Hello, world!"
    }

    /*
    func showVariables() -> String {
        var myVariable = 42
            myVariable = 50

        let myConstant = 42
        //myConstant = 33 //will not compile

        let explicitDouble: Double = 70.0

        return "Hello, world!"
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Optionals

    fun greet(name: String, day: String): String {
        var result: String? = null
        result = "Hello $name, today is ${day})."

        println("length: ${ result?.length }")
        println("length: ${ result!!.length }")

        return result
    }

    /*
    func greet(name: String, day: String) -> String {
        var result: String? = nil
            result = "Hello \(name), today is \(day)."

        print("length: \(result?.characters.count)")
        print("length: \(result!.characters.count)")

        return result!
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Unwrapping
    fun doSomething(someArg: String?) {
        val arg = someArg?.let { it } ?: return

        //do something
        print(someArg)
    }

    fun doSomething2(someArg: String?) {
        someArg?.let {
            //do something
            println(it)
        }
    }

    /*
    func doSomething(someArg: String?) {
        guard let someArg = someArg else { return }

        //do something
        print(someArg)
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Arrays

    fun showArrays() {
        val names = arrayOf("Anna", "Alex", "Brian", "Jack")

        for ((i, name) in names.withIndex()) {
            print("Person ${ i + 1 } is called $name")
        }

        // Person 1 is called Anna
        // Person 2 is called Alex
        // Person 3 is called Brian
        // Person 4 is called Jack
    }

    /*
    func showArrays() {
        let names = ["Anna", "Alex", "Brian", "Jack"]

        for (i, name) in names.enumerated() {
            print("Person \( i + 1 ) is called \( name )")
        }

        // Person 1 is called Anna
        // Person 2 is called Alex
        // Person 3 is called Brian
        // Person 4 is called Jack
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Lists

    fun showLists() {
        val names = listOf("Anna", "Alex", "Brian", "Jack")

        for ((index, name) in names.withIndex()) {
            println("Person ${index + 1} is called $name")
        }
    }

    //endregion
    // -----------------------------------------------------------
    //region Dictionaries

    fun dictionaries() {
        val occupations = mutableMapOf(
                "Malcolm" to "Captain",
                "Kaylee" to "Mechanic"
        )

        occupations["Jayne"] = "Public Relations"
    }

    /*
    func dictionaries() {
        var occupations = [
                "Malcolm": "Captain",
                "Kaylee": "Mechanic"
                ]

        occupations["Jayne"] = "Public Relations"
    }
    */

    //endregion
    // -----------------------------------------------------------
    //region Mutable Types

    fun showLists2() {

        val namesArray = arrayOf("Anna", "Alex", "Brian", "Jack")
//        namesArray.add

        val names = listOf("Anna", "Alex", "Brian", "Jack")
        println("names.count(): ${ names.count() }")

        val names2 = mutableListOf("Anna", "Alex", "Brian", "Jack")
        names2.add("Naruto")
        println("names2.count(): ${ names2.count() }" )

 //-----------------------------------------------------------------

        val nameToAge = mapOf("Anna" to 35,
                "Alex" to 27,
                "Brian" to 64,
                "Jack" to 55)
        println("nameToAge.size: ${ nameToAge.size }")

        val mutableMap = nameToAge.toMutableMap()
        mutableMap["James"] = 39
        mutableMap["Brain"] = 72

// -----------------------------------------------------------------

        val nameToAge2 = mutableMapOf("Anna" to 35,
                "Alex" to 27,
                "Brian" to 64,
                "Jack" to 55)
        nameToAge2["Naruto"] = 32
        println("nameToAge2.size: ${ nameToAge2.size }")
    }

    //endregion
    // -----------------------------------------------------------
    //region 1 more thing
    //Collections are reference types, like most objects in Kotlin
    //endregion
    // -----------------------------------------------------------
}
