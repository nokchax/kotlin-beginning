package ch02

fun main() {
    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"

    val answer = 42 // 초기화 식, 타입 생략
    val answer2: Int = 42 // 초기화 식, 타입 명시

    val yearsToCompute = 7.5e6 // double 7.5 * 10^6
    println(yearsToCompute.javaClass) // double

    val answer3: Int //초기화 식이 없다면, 타입추론이 불가함 -> 타입이 반드시 필요
    answer3 = 42

    val unmodifiableValue = 10;
    var modifiable = 5

    modifiable = 10
//    unmodifiableValue = 5 // compile error

    val message: String
    if (true) {
        message = "True"
    } else {
        message = "False"
    }

    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    var answer4 = 42
//    answer4 = "no answer" // compile error (type mismatch)
}