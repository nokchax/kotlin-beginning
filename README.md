# kotlin-beginning
## docs
- [kotlin docs](https://kotlinlang.org/docs/home.html)
## 서적
- [kotlin in action](http://www.yes24.com/Product/Goods/55148593?OzSrank=2)

# syntax
- [syntax](https://kotlinlang.org/docs/basic-syntax.html)

## Package definition and imports
패키지 선언은 소스 파일의 최 상단에 위치해야 합니다.
```kotlin
package my.demo

import kotlin.text.*

// ...
```
디렉토리와 패키지를 일치시킬 필요는 없습니다. 소스 파일은 파일 시스템에 따라 제멋대로(임의로) 배치될 수 있습니다.

## Program entry point
코틀린 어플리케이션에서 시작점은 `main` 함수 입니다.

```kotlin
fun main() {
  println("Hello world!")
}
```

``main`` 함수는 아래와 같이 String 값들을 인자로 받을 수 있습니다.
```kotlin
fun main(args: Array<String>) {
  println(args.contentToString())
}
```

## Print to the standard output
``print`` 함수는 전달받은 인자를 표준 출력에 찍어냅니다.
```kotlin
print("Hello ")
print("world!")
```
``println`` 인자를 출력할 뿐만 아니라 줄바꿈을 추가합니다.
```kotlin
println("Hello world!")
println(42)
```

## Functions
아래는 두개의 `Int` 매개변수와 `Int` 리턴 타입을 갖는 함수입니다.
```kotlin
fun sum(a: Int, b: Int): Int {
  return a + b
}
```

함수의 바디는 식으로 대체 될 수 있고, 리턴 타입은 추론할 수 있습니다.
```kotlin
fun sum(a: Int, b: Int) = a + b
```

함수는 의미없는 값을 반환 할 수 있습니다.
```kotlin
fun printSum(a: Int, b: Int): Int {
  println("sum of $a and #b is ${a + b}")
}
```
- java 에서 void
- Unit은 객체인가?
- 출력할 수 있나?

``Unit`` 리턴 타입은 생략가능
```kotlin
fun printSum(a: Int, b: Int) {
  println("sum of $a and #b is ${a + b}")
}
```
