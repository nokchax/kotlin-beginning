# Idioms (관용)
코틀린에서 무작위로 자주 사용되는 관용구 모음.

## Create DTOs(POJOs/POCOs)
```kotlin
data class Customer(val name: String, val email: String)
```
위처럼 정의할때 `customer` 클래스와 함께 아래의 기능을 제공한다.
- 모든 속성에 대해 getter를 제공(`var` 를 사용한경우 setter도 제공)
- equals()
- hashCode()
- toString()
- copy()
- 모든 속성에 대해 component1(), component2(), ...

## Default values for function parameters
함수 매개변수의 기본값
```kotlin
fun foo(a: Int = 0, b: String = "") { ... }
```

## Filter a list
```kotlin
val positives = list.filter { x -> x > 0 }
```
혹은 더 짧게
```kotlin
val positives = list.filter { it > 0 }
```

## Check the presence of an element in a collection
```kotlin
if ("nokchax@gmail.com" in emailsList) { ... }
if ("nokchax@gmail.com" !in emailsList) { ... }
```

## String interpolation (써넣음)
```kotlin
println("Name $name")
```

## Instance checks
```kotlin
when (x) {
  is Foo -> ...
  is Bar -> ...
  else   -> ...
}
```

## Read-only list
```kotlin
val list = listOf("a", "b", "c")
```

## Read-only map
```kotlin
val map = mapOf("a" to 1, "b" to 2, "c" to 3)
```

## Access a map entry
```kotlin
println(map["key"])
map["key"] = value
```

## Traverse a map or a list of pairs
```kotlin
for ((k, v) in map) {
  println("$k -> $v")
}
```

## Iterate over a range
```kotlin
for (i in 1...100) { ... } // closed range: 100 포함
for (i in 1 until 100) { ... } // half-open range: 100 
for (x in 2..10 step 2) { ... }
for (x in 10 downTo 1) { ... }
if (x in 1..10) { ... }
```

## Lazy property
```kotlin
val p: String by lazy {
  // compute the string
}
```

## Extension functions
```kotlin
fun String.spaceToCamelCase() { ... }
"Convert this to camelcase".spaceToCamelCase()
```

## Create a singleton
```kotlin
object Resource {
  val name = "name"
}
```

## Instantiate an abstract class
```kotlin
abstract class MyAbstractClass {
  abstract fun doSomething()
  abstract funsleep()
}

fun main() {
  val myObject = object : MyAbstractClass() {
    override fun doSomething() { ... }
    override fun slepp() { ... }
  }
  myOjbect.doSomething()
}
```

## If-not-null shorthand
```kotlin
val files = File("Test").listFiles()
println(files?.size) // files가 null이 아닐경우 size가 출력된다.
```

## If-not-null-else shorthand(속기, 약칭)
```kotlin
val files = File("Test").listFiles()
println(files?.size ?: "empty") // files가 null이면 empty 출력
```

## Execute a statement if null
```kotlin
val values = ...
val email = values["email"] ?: throw IllegalsStateException("Eamil is missing!")
```

## 비어 있을 가능성이 있는 컬렉션에서 첫번째 아이템 가져오기
```kotlin
val emails = ... // 비어있을지도 모름
val mainEmail = emails.firstOrNull() ?: ""
```

## null이 아닐경우에 실행하기
```kotlin
val value = ...
value?.let {
  ... // execute this block if not null
}
```

## null일 가능성이 있는 값을 null이 아닐경우 맵핑하기
```kotlin
val value = ...
val mapped = value?.let { transformValue(it) } ? : defaultValue
// value나 transformValue의 결과가 null인 경우에는 defaultValue가 반환됨
```

## when 구문에서의 반환
```kotlin
fun transform(color: String): Int {
  return when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
  }
}
```

## try-catch 구문
```kotlin
fun test() {
  val resutl = try {
    count()
  } catch (e: ArithmeticException) {
    throw IllegalStateException(e)
  }
  
  // 결과값으로 나머지 수행
}
```

## if 구문
```kotiln
fun foo(param: Int) {
  val result = if (paramm == 1) {
    "one"
  } else if (param == 2) {
    "two"
  } else {
    "three"
  }
}
```

## Unit을 반환하는 함수의 Builder-style 사용법
```kotlin
fun arrayOfMinusOnes(size: Int): IntArray {
  return IntArray(size).apply { fill(-1) }
}
```

## 단일 식 함수
```kotlin
fun theAnswer() = 42
```
아래와 동일함
```kotlin
fun theAnswer(): Int {
  return 42
}
```
이러한 방식은 다른 관용구와 효율적으로 조합하여, 더 짧은 코드로 이어질 수 있다. 예를들어 위에서 when 구문과 합치면
```kotlin
fun transform(color: String): Int = when (color) {
  "Red" -> 0
  "Green" -> 1
  "Blue" -> 2
  else -> throw IllegalArgumentException("Invalid color param value")
}
```

## 하나의 인스턴스에서 다수의 함수 호출하기 (with)
```kotlin
class Turtle {
  fun penDown()
  fun pendUp()
  fun turn(degrees: Double)
  fun forward(pixels: Double)
}

val myTurtle = Turtle()
with(myTurtle) {
  pendDown()
  for (i in 1..4) {
    forward(100.0)
    turn(90.0)
  }
  penUP()
}
```
잘 이해가 안 돼서 다른 [예제](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29) 참고
```kotlin
class Person {
  var name: String? = null
  var age: Int? = null
}
val person: Person = getPerson()
print(person.name)
print(person.age)
```
다음 코드는 person의 중복 사용을 제거하기 위해 범위 지정 함수 with 를 사용한다는 점을 제외하고는 위와 동일
```kotlin
val person: Person = getPerson()
with(person) {
  print(name)
  print(age)
}
```

## 객체의 속성(properties) 설정하기 (apply)
```kotlin
val myRectangel = Rectangel().apply {
  length = 4
  breadth = 5
  color = 0xFAFAFA
}
```
이러한 방식은 객체의 생성자에는 보이지 않는 속성을 설정하는데 유용하다.

## Java7에서의 try-with-resource
```kotlin
val stream = Files.newInputStream(Paths.get("/some/file.txt"))
stream.buffered().reader().use { reader -> println(reader.readTest()) }
```

## 제네릭 타입 정보가 필요한 제네릭 함수
```kotlin
// public final class Gson {
//   ...
//   public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
//   ...

inline fun <reified T: Any> Gson.fromJson(json: JsonElemtns): T = this.fromJson(json, T::class.java)
```


## nullable boolean
```kotlin
val b: Boolean? = ...
if (b == true) {
  ...
} else {
  // b is false or null
}
```

## 두 변수 바꾸기
```kotlin
var a = 1
var b = 2
a = b.also { b = a }
```

## 코드를 미완성으로 표시하기 (todo)
코틀린의 표준 라이브러리는 `TODO()` 라는 함수를 표함하고 있다. 이 함수는 `NotImplementedError` 예외를 항상 던진다.
이 함수의 반환 타입은 `Nothing` 이며 예상되는 유형과는 관계없이 사용가능하다.
이유 파라미터를 받을수 있는 `overload`가 존재한다.
```kotlin
fun calcTaxes(): BigDecimal = TODO("Waiting for feddback from accounting")
```
