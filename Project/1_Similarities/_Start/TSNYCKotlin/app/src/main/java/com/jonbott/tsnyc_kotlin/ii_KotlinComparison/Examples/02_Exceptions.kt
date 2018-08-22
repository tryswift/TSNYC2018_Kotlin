package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

class CustomException(override var message: String) : Exception()

object Exceptions {
    fun example1() {
    }

    fun example2(someArg: String): Int? {
        return null
    }

    fun example3(){ //this will crash - throw not required
        faultCode("error out")
    }
}

private fun faultCode(message: String): Nothing {
    throw IllegalArgumentException(message)
}

/*

//common exceptions
ArithmeticException
ArrayIndexOutOfBoundsException
ClassCastException
ClassNotFoundException
CloneNotSupportedException
IllegalArgumentException
IllegalMonitorStateException
IllegalThreadStateException
IndexOutOfBoundsException
InterruptedException
NullPointerException
NumberFormatException

//util exceptions
ConcurrentModificationException

//io exceptions
EOFException
FileNotFoundException
IOException
NotSerializableException

 */