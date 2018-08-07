package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Helpers.digitize
import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Helpers.digitize2

class Image(val width: Int, val height: Int, val url: String)

//region Basic Extensions

fun Image.convertToBlackAndWhite(): Image {
    //alter image somehow
    val changedImage = this
    return changedImage
}

//endregion

//region Extension Properties

val Image.area
    get() = width * height

//Can use setters
var Image.score
    get() = 10
    set(value) {
        println("Value has changed: $value")
    }

//endregion

//region Optional Extensions

fun Image?.alterAnotherWay() {
    if (this == null) return

    //do something
}

//endregion

object Extensions {
    fun example1() {
        var image: Image? = null
        image.alterAnotherWay()

        var image2 = Image(100, 100, "some url")
        var result = image2.digitize()


        var result2 = image2.digitize2()

    }

    fun example2() {
        var clash = ClashingClass()
        clash.someMethod()
        clash.someMethod(23)
    }
}