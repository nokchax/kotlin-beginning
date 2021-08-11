package ch03

fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 523)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three") // 여기서 to 는 키워드가 아니라 일반 함수

    println(set.javaClass) // java's getClass()
    println(set)

    println(list.javaClass)
    println(list)

    println(map.javaClass)
    println(map)
}
/*
    class java.util.HashSet
    [1, 523, 7]

    class java.util.ArrayList
    [1, 7, 53]

    class java.util.HashMap
    {1=one, 53=fifty-three, 7=seven}
*/

/*
 * Creates a tuple of type [Pair] from this and [that].
 *
 * This can be useful for creating [Map] literals with less noise, for example:
 * @sample samples.collections.Maps.Instantiation.mapFromPairs

    public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
*/

