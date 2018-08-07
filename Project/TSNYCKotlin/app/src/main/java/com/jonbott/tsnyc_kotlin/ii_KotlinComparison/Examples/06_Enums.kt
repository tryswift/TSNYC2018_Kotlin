package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples


//region Simple Enums

enum class ActionStates {
    RUN, WALK, JUMP, SIT, STAND, WAIT
}

//endregion

//region Associated Values

enum class Color(val rgb: Int) {
    RED(0xff0000),
    GREEN(0x00ff00),
    BLUE(0x0000ff)
}

//endregion

object EnumClasses {

    //Enums aren't Strings or Ints, but do have both name and Int values
    fun example1() {
        println("number: ${Color.RED.ordinal}")
        println("name: ${Color.RED.name}")

        //ordinal index based off the order enum is created in
        val ordinalIndex = 2
        var color = Color.values()[ordinalIndex]
        println("color: $color")

        try {
            val color2 = Color.valueOf("BadValue")
            println("color2: $color2")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}


