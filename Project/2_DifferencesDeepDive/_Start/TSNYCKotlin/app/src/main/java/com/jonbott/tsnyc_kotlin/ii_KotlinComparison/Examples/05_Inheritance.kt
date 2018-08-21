package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples


class Example // Implicitly inherits from Any
/*
Any has equals(), hashCode() and toString()
 */


//region Simple Inheritance
open class Base {
    open fun someFunction() {}
    fun otherFunction() {}
}

class Derived: Base() {
    override fun someFunction() {}
}

open class AnotherDerived(): Base() {
    final override fun someFunction() { }
}

//endregion

//region Altering Inherited properties
open class Base2 {
    open val x: Int = 1
    var y: Int = 3
}

class Derived2: Base2() {
    override val x: Int = 13
//    var y: Int = 7
}
//endregion

//region Where to override properties
interface Sample {
    val count: Int
}

class SampleImpl(override val count: Int): Sample

class SampleImpl2: Sample {
    override val count: Int = 0
}


//endregion



object Inheritance {
    fun example() {
        val sampleImpl2 = SampleImpl2()
        println("sampleImpl2.count: ${sampleImpl2.count}")
    }
}