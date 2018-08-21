package com.jonbott.everydaykotlin

class Challenge {

    fun process(names: List<String>): List<String> {
        return names.filter { it.length > 5 }
                .sortedBy { it }
                .map { it.toLowerCase() }

    }
    /*
Create class
Add function
    Sorts a list
    length greater than 5
    sort by name
    to lower case
Create instance
Use it in the MainActivity
    Call the method

names:
    "Schultz", "Cuevas", "Rhodes", "Mckenzie", "Taylor", "Glenn", "Reilly", "Morris", "Herman", "Beltran", "Swanson", "Roth"
 */
}