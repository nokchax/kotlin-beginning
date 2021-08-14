package ch02

fun max(a: Int, b: Int): Int { // 블록({})이 본문인 함수
    return if (a > b) a else b // if else 는 식 따라서 값을 반환, 자바에서는 문
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b // 식이 본문인 함수
fun max3(a: Int, b: Int) = if (a > b) a else b // 타입 추론

fun main() {
    println(max(1, 2))
    println(max2(1, 2))
}

// 2
// 2