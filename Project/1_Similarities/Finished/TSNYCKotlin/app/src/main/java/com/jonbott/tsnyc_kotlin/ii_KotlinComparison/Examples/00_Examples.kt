package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples

object Examples {
    fun run() {
        runLambdaExamples()
        runExceptionExamples()
        runInterfaceExamples()
        runClassesExamples()
        runInheritanceExamples()
        runEnumClassesExamples()
        runGenericsExamples()
        runExtensionExamples()
        runJavaInteropExamples()
    }
}

//region Examples

private fun runLambdaExamples() {

}

private fun runExceptionExamples() {
    Exceptions.example1()
    val result = Exceptions.example2("bad value")
    println("result: $result")

//    Exceptions.example3()
}

private fun runInterfaceExamples() {
//    Interfaces.basics()
    Interfaces.multipleInterfaces()
}

private fun runClassesExamples() {
    Classes.example1()
}

private fun runInheritanceExamples() {
    Inheritance.example()
}

private fun runEnumClassesExamples() {
    EnumClasses.example1()
}


private fun runGenericsExamples() {
    Generics.basicGenerics()
}

private fun runExtensionExamples() {
    Extensions.example1()
    Extensions.example2()
}

private fun runJavaInteropExamples() {
    JavaFromKotlin.examples()
//    KotlinFromJava.examples()
}

//endregion

//region helper methods
fun authenticate(result: String): Boolean = result == "Naruto Uzumaki"
//endregion
