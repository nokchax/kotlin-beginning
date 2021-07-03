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

