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

## Variables
읽기만 가능한 지역 변수는 `val`키워드를 이용해서 선언할 수 있습니다. 값을 단 한번만 할당할 수 있다.
```kotlin
val a: Int = 1 // 즉시 할당
val b = 2 // Int 타입 유추
val c: Int // 초기화가 안될 경우에는 타입이 필요하다.
c = 3 // 지연 할당? (defeerred assignment)
```

변수는 값의 재할당이 가능하며 `var` 키워드를 사용한다.
```kotlin
var x = 5 // Int 타입 유추
x += 1
```

top level에 변수선언도 가능하다.
```kotlin
val PI = 3.14
var x = 0

fun incrementX() {
  x += 1
}
```
top level은 뭐지?
> Top level : A top level declaration is a function or property which is defined outside any class, object, interface or other structure.

참고 
- https://discuss.kotlinlang.org/t/singleton-top-level-declaration-module/7711
- https://velog.io/@cchloe2311/Kotlin-Kotlin%EC%97%94-static-%ED%82%A4%EC%9B%8C%EB%93%9C%EA%B0%80-%EC%97%86%EB%8B%A4

## Creating classes and instances
클래스를 정의하기 위해 `class` 키워드를 사용한다
```kotlin
class Shape
```

클래스의 속성(property) 클래스의 선언부나 바디에 나열할 수 있다.
```kotlin
class Rectangle(var height: Double, var length: Double) {
  var perimeter = (height + length) * 2
}
```

클래스 선언에 나열되어있는 파라미터가 있는 기본 생성자는 자동으로 사용가능하다.??
> The default constructor with parameters listed in the class declaration is available automatically.
```kotlin
val rectangle = Rectangle(5.0, 2.0)
println("The perimeter is ${rectangle.perimeter}")
```

클래스 사이에 상속은 `colon :` 을 사용한다. 클래스는 기본적으로 final(변경할 수 없는, 불변의) 이며. 상속가능하게 하기 위해서는 `open` 키워드로 표시해야한다.

```kotlin
open class Shape

class Rectangle(var height: Double, var length: Double): Shape() {
  var perimeter = (height + length) * 2
}
```

## Comments
대부분의 최신 언어들과 마찬가지로 한줄, 블락 코멘트를 지원한다.
```kotlin
// 한줄 코멘트
/* 
  블락 코멘트
*/
```

중첩된 코멘트도 지원한다.
```kotlin
/* The comment starts here
/* contains a nested comment */
and ends here. */
```

## String template
```kotlin
var a = 1
// simple name in template:
val s1 = "a is $a" 

a = 2
// arbitrary expression in template:
val s2 = "${s1.replace("is", "was")}, but now is $a"
```
```
a was 1, but now is 2
```

## Conditional expressions
```kotlin
fun maxOf(a: Int, b: Int): Int {
  if (a > b) {
    return a
  } else {
    return b
  }
}
```
코틀린에서 `if`는 하나의 식으로도 사용된다?
> In Kotlin, if can also be used as an expression.
```kotlin
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```

## for loop
```kotlin
val items = listOf("apple", "banana", "kiwifruit")
for (item in items) {
  println(item)
}
```
```
apple
banana
kiwifruit
```
혹은
```kotlin
val items = listOf("apple", "banana", "kiwifruit")
for (index in items.indices) {
   println("item at $index is ${items[index]}")
}
```
```
item at 0 is apple
item at 1 is banana
item at 2 is kiwifruit
```

## while loop
```kotlin
val items = listOf("apple", "banana", "kiwifruit")
var index = 0
while (index < items.size) {
  println("item at $index is ${items[index]}")
  index++
}
```
```
item at 0 is apple
item at 1 is banana
item at 2 is kiwifruit
```

## when expression
```kotlin
fun describe(obj: Any): String =
  when (obj) {
    1          -> "One"
    "Hello"    -> "Greeting"
    is Long    -> "Long"
    !is String -> "Not a string"
    else       -> "Unknown"
  }
```

## Ranges
```kotlin
val x = 10
val y = 9
if (x in 1..y+1) {
  println("fits in range")
}
```
```
fits in range
```

```kotlin
val list = listOf("a", "b", "c")

if (-1 !in 0..list.lastIndex) {
  println("-1 is out of range")
}
if (list.size !in list.indices) {
  println("list size is out of valid list indices range, too")
}
```
list.indices 가 0..2 로 해석되는건가?
```
-1 is out of range
list size is out of valid list indices range, too
```

```kotlin
for (x in 1..5) {
  print(x)
}
```
```
12345
```
```kotlin
for (x in 1..10 step 2) {
  print(x)
}
println()
for (x in 9 downTo 0 step 3) {
  print(x)
}
```
```
13579
9630
```

## Collections
컬렉션 반복
```klotlin
for (item in items) {
  println(item)
}
```
컬렉션이 객체를 가지고 있는지 확인하려면 `in` 연산자를 사용하면 된다.
```kotlin
when {
  "orange" in items -> println("juicy")
  "apple" in items -> println("apple is fine too")
}
```
컬렉션을 filter와 map을 하기 위해 람다식을 사용한다.
```kotlin
val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
fruits
  .filter { it.startsWith("a") }
  .sortedBy { it }
  .map { it.uppercase() }
  .forEach { println(it) }
```
```
APPLE
AVOCADO
```

## Nullable values and null checks
참조형은 값으로 `null`일 가능성이 았다면 명시적으로 nullable이라 표시해줘야 하며, 이때 nullable 타입은 끝에 `?`를 갖는다.

str이 integer값을 가지고 있지 않을경우 null을 리턴
```kotlin
fun parseInt(str: String): Int? {
  // ...
}
```
nullable 값을 반환하는 함수 사용하기
```kotlin
fun printProduct(arg1: String, arg2: String) {
  val x = parseInt(arg1)
  val y = parseInt(arg2)

  // Using `x * y` yields error because they may hold nulls.
  if (x != null && y != null) {
    // x and y are automatically cast to non-nullable after null check
    println(x * y)
  }
  else {
    println("'$arg1' or '$arg2' is not a number")
  }    
}
```
혹은
```kotlin
// ...
if (x == null) {
  println("Wrong number format in arg1: '$arg1'")
  return
}
if (y == null) {
  println("Wrong number format in arg2: '$arg2'")
  return
}

// x and y are automatically cast to non-nullable after null check
println(x * y)
```

## Type checks and automatic casts
`is` 연산자는 식이 타입의 인스턴스인지 아닌지를 체크한다. 만약 불변의 지역 변수나 프로퍼티 특정 타입으로 체크된 이후에는 명시적으로 캐스트할 필요가 없다.
```kotlin
fun getStringLength(obj: Any): Int? {
  if (obj is String) {
    // `obj` is automatically cast to `String` in this branch
    return obj.length
  }

  // `obj` is still of type `Any` outside of the type-checked branch
  return null
}
```
혹은
```kotlin
fun getStringLength(obj: Any): Int? {
  if (obj !is String) return null

  // `obj` is automatically cast to `String` in this branch
  return obj.length
}
```
혹은
```kotlin
fun getStringLength(obj: Any): Int? {
  // `obj` is automatically cast to `String` on the right-hand side of `&&`
  if (obj is String && obj.length > 0) {
  return obj.length
  }

  return null
}
```
