package ch03

fun main(args: Array<String>) {
    val strings = listOf("first", "second", "fourteenth")
    val numbers = setOf(1, 14, 2)

    println(strings.last())
    println(numbers.maxOrNull()) // max() is deprecated
}

/*
    fourteenth
    14
 */