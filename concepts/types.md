# 기본 타입
코틀린에서 모든 변수에서 멤버 함수와 프로퍼티를 호출할수 있다는 점에서 모든 것은 객체다.
몇몇 타입은 특수한 내부 표현을 가진다.
예를 들어 numbers, characters 그리고 booleans 는 런타임에서 원시 타입으로 표시된다.
하지만 사용자가 보기에는 평범한 클래스로 보인다.
이번 장에서는 코틀린에서 사용되는 기본 타입에 대해서 논의해 본다.
`numbers`, `booleans`, `characters`, `strings`, `arrays`

## Numbers
### 정수 타입 (Integer type)
코틀린은 숫자를 표현하는 내장 타입 세트를 제공한다. 정수에는 네 가지 서로 다른 크기와 값 범위를 가지는 타입이 존재한다.
(sizes and, hence, value ranges. 여기서 hence는 뭐라고 해석 하는지 모르겠다)

|Type|Size(bits)|Min value|Max value|
|---|---|---|---|
|Byte|8|-128|127|
|Short|16|-32768|32767|
|Int|32|-2,147,483,648(-2^31)|2,147,483,647(2^31-1)|
|Long|64|-9,223,372,036,854,775,808(-2^63)|9,223,372,036,854,775,807(2^63-1)|

`Int` 의 최대값을 넘지 않는 정수값으로 초기화 되는 모든 변수는 추론된 `Int` 타입을 가진다.
만약 초기값이 이 최대값을 넘는다면, 이 변수의 타입은 `Long`입니다. `Long` 값임을 명시하기 위해서는 값의 접미사롤 `L`을 추가한다.
```kotlin
val one = 1 // Int
val threeBillion = 3000000000 // Long
val oneLong = 1L // Long
val oneByte: Byte = 1
```

### 부동 소수점 타입 (Floating-point types)
실수의 경우 코틀인에서는 `Float`와 `Double`을 제공한다. IEEE 754 표준에 따르면, 실수 타입은 소수점 위치에 따라 다르다.
(Floating point types differ by their decimal place, tha is, how many decimal digits they can store)
`Float`은 IEEE 754의 단일 정밀도(single precision)을 따르는 반면 `Double`은 이중 정밀도(double precision)을 따른다.

|Type|Size(bits)|Significant bits|Exponent(지수) bits|Decimal digits|
|---|---|---|---|---|
|Float|32|24|8|6-7|
|Double|64|53|11|15-16|

`Double`과 `Float` 변수는 소수 부분이 있는 숫자를 가지고 초기화 한다.
소수 부분는 정수 부분으로 부터 마침표(.) 에 의해 분리된다. -> 정수 부분과 소수부분은 마침표(.)로 의해 분리된다.

```kotlin
val pi = 3.14 // Double
// val one: Double = 1 // Error: type mismatch
val oneDouble = 1.0 // Double
```

값이 `Float` 타입임을 명시적으로 지정하기 위해서는 접미사 `f` 혹은 `F`를 추가한다. 만약 값이 6-7 자리수 이상 포함한다면, 반올림된다. (rounded 반올림)
```kotllin
val e = 2.7182818284 // Double
val eFloat = 2.7182818284f // Float, 실제 값은 2.7182817
```

코틀린은 다른 언어들과는 다르게 암시적인 숫자 확장 변환을 지원하지 않는다는 점에 주의. 예를 들어 `Double` 파라미터를 가지는 함수는 `Double` 값으로만 호출 할 수 있으며, `Float`과 `Int` 혹은 다른 숫자 값은 호출할 수 없다.
```kotlin
fun main() {
  fun printDouble(d: Double) { print(d) }

  val i = 1
  val d = 1.0
  val f = 1.0f

  printDouble(d)
//printDouble(i) // Error: Type mismatch
//printDouble(f) // Error: Type mismatch
}
```
숫자 값을 다른 타입으로 변환하려면 [명시적 변환](https://kotlinlang.org/docs/basic-types.html#explicit-conversions)을 사용.

### 리터럴 상수
정수 값(integral value 사전에는 적분값이라 정의되어 있는데, 여기서는 [integral number](https://www.quora.com/What-are-integral-numbers) 즉 정수를 뜻하는 듯하다) 에는 아래와 같은 리터럴 상수가 존재한다.
- 십진법: 123
- Long 타입은 대문자 `L`이 붙는다: 123L
- 16진법: 0x0F
- 2진법: 0b00001011
> 주의! 8진법은 제공하지 않음

또한 코틀린은 부동 소수점 숫자에 대해 관습적인 표기법을 지원한다.
- 기본적으로 Double: 123.5, 123.5e10
- `f`나 `F`가 붙으면 Float: 123.5f

숫자를 더 쉽게 읽기 위해 `_` 언더스코어를 사용할 수 있다.
```kotlin
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
```

### JVM상에서의 숫자 표현
JVM 플랫폼 상에서 숫자는 원시 타입으로 저장된다, `int`, `double` 기타 등등.. 그러나 `Int?`와 같은 nullable 숫자를 생성하거나 제네릭을 사용하는 경우는 예외다. 이러한 경우에 숫자는 `Integer`, `Double`과 같은 자바 클래스로 감싸진다.

주의! 동일한 숫자에 대한 nullable 참조는 서로 다른 객체일 수 있다.
```kotlin
val a: Int = 100
val boxedA: Int? = a
val anotherBoxedA: Int? = a

val b: Int = 10000
val boxedB: Int? = b
val anotherBoxedB: Int? = b

println(boxedA === anotherBoxedA) // true
println(boxedB === anotherBoxedB) // false
```
`-128` 에서 `127` 사이의 숫자 값에 대해서 JVM은 메모리 최적화를 하기 때문에 `a`에 대한 모든 nullable 참조는 사실상 동일한 객제이다.
하지만 `b`에 대한 참조는 이 숫자 사이의 값이 아니므로 서로 다른 객체다.

반면에 이 변수들은 여전히 동등하다(equal).
> 동일성과 동등성
```kotlin
val b: Int = 10000
println(b == b) // Prints 'true'
val boxedB: Int? = b
val anotherBoxedB: Int? = b
println(boxedB == anotherBoxedB) // Prints 'true'
```

### 명시적 변환
서로 다른 표현 때문에, 작은 타입은 큰타입의 서브타입이 아니다. 만약 그렇다면 우리는 아래와 같은 문제에 직면한다.
```kotlin
// 아래 코드는 가정이므로 실제로 컴파일 되지 않는다.
val a: Int? = 1 // A boxed Int (java.lang.Integer)
val b: Long? = a // implicit conversion yields a boxed Long (java.lang.Long)
print(b == a) // long의 equals()는 값 뿐만 아니라 다른 변수가 Long인지도 확인하므로 false를 출력한다.
```
따라서 동일성은 물론이고 동등성 마져 없어졌다.

그 결과 작은 타입은 큰 타입으로의 암묵적 변환은 되지않는다. `Byte` 타입의 값을 `Int` 타입의 변수에 할당하기 위해선 명시적인 변환이 필요함을 의미한다.
```kotlin
val b: Byte = 1
// val i: Int = b // ERROR
val i1: Int = b.toInt()
```

모든 숫자타입은 다른 타입으로의 변환을 제공한다.
- toByte(): Byte
- toShort(): Short
- toInt(): Int
- toLong(): Long
- toFloat(): Float
- toDouble(): Double
- toChar(): Char

대부분의 경우에 명시적 변환을 할 필요가 없다. 왜냐하면 타입이 문맥에 의해서 추론되거나, 적절한 변환을 위해 산술 연산이 오버로드 되기 때문이다. 예를들면 아래와 같다
```kotlin
val l = 1L + 3 // Long + Int => Long
```

### 연산
코틀린은 숫자에 대한 표준적인 산술 연산 집합을 제공한다. `+`, `-`, `*`, `/`, `%`. 이 연산자들은 적절한 클래스의 member로 선언되어 있다.
```kotlin
println(1 + 2)
println(2_500_000_000L - 1L)
println(3.14 * 2.71)
println(10.0 / 3)
```
또한 이 연산자들을 커스텀 클래스에 대해 재정의 할 수 있다. [operator overloading](https://kotlinlang.org/docs/operator-overloading.html) 참조

#### 정수 나눗셈
정수 간의 나눗셈은 항상 정수를 반환한다. 모든 소수 부분은 버려진다.
```kotlin
val x = 5 / 2
//println(x == 2.5) // ERROR: Operator '==' cannot be applied to 'Int' and 'Double'
println(x == 2)
```
어떠한 정수 타입간의 나눗셈이라도 마찬가지다.
```kotlin
val x = 5L /2
println(x == 2L)
```
부동 소수점 타입으로 반환하기 위해서는 명시적으로 하나의 인수를 부동 소수점 타입으로 변환해야한다.
```kotlin
val x = 5 / 2.toDouble()
println(x == 2.5)
```

#### 비트연산 (bitwise operations)
코틀린은 정수에 대해 비트 연산을 제공한다. 숫자 표현의 비트를 사용하여 이진법의 레벨에서 직접적으로 작동한다. 비트 연산은 삽입 형식으로 불리는 함수를 사용해 표현하다. `Int`와 `Long`에만 적용 가능하다.
```kotlin
val x = (1 shl 2) and 0x00FF000
```
비트 연산자 종류
- shl(bits): signed shift left
- shr(bits): signed shift right
- ushr(bits): unsigned shift right
- and(bits): and 연산
- or(bits): or 연산
- xor(bits) xor 연산
- inv(): 비트 

### 부동 소수점 숫자의 비교
이번 섹션에서 다뤄볼 부동 소수점 숫자 연산자는 아래와 같다.
- 동등성 확인: `a == b` 와 `a != b`
- 비교 연산: `a < b`, `a > b`, `a <= b`, `a >= b`
- 범위 인스턴스화와 범위 확인: `a..b`, `x in a..b`, `x !in a..b`

When the operands a and b are statically known to be Float or Double or their nullable counterparts (the type is declared or inferred or is a result of a smart cast ), the operations on the numbers and the range that they form follow the IEEE 754 Standard for Floating-Point Arithmetic.

However, to support generic use cases and provide total ordering, when the operands are not statically typed as floating point numbers (e.g. Any, Comparable<...>, a type parameter), the operations use the equals and compareTo implementations for Float and Double, which disagree with the standard, so that:

피언산자 `a`와 `b`가 변하지 않는 `Float` 나 `Double`인 경우이거나 nullable

그러나, 제네릭을 사용하는 경우나 

연산은 `Float`과 `Double`에 구현된 `equals`와 `compareTo`를 사용하며, 이는 일반적인 `equals`와 `compareTo`와는 다르다. 따라서,
- `NaN` 은 자신과 동일하다고 간주한다.
- `NaN` 은 `POSITIVE_INFINITY` 를 포함한 그 어떠한 요소보다 크다고 간주한다.
- `-0.0`은 `0.0`보다 작다고 간주한다.

### 부호 없는 정수 (Unsigned integer)
정수 타입에 더해 코틀린은 아래와 같은 부호가 없는 숫자 타입을 제공한다.
- `UByte`: 부호없는 8-bit 숫자, 범위는 0 ~ 255
- `UShort`: 부호없는 16-bit 숫자, 범위는 0 ~ 65535
- `UInt`: 부호없는 32-bit 숫자, 범위는 0 ~ 2^32 - 1
- `ULong`: 부호없는 64-bit 숫자, 범위는 0 ~ 2^64 - 1

부호 없는 타입은 그 타입에 해당하는 부호 있는 타입의 연산의 대부분을 지원한다.
> 부호 없는 타입에서 부호 있는 타입으로의 전환이나 그 반대의 경우는 이진 호환되지 않는다.

### Unsigned arrays and ranges
Unsigned arrays는 아직 베타이기 때문에 스킵

### 리터럴
부호 없는 정수를 사용하기 쉽게 하기 위해, 코틀린은 정수 리터럴에 특정 부호없는 타입을 지칭하는 접미어 태그 기능을 제공한다. 
- `u` 와 `U` 태그는 u 부호없는 리터럴. 정확한 타입은 예상 타입에 기반하여 정해진다. 예상 타입이 없다면, 컴파일러는 `UInt` 나 `ULong` 를 사용하며, 리터럴의 크기에 따라 정해진다.
```kotlin
val b: UByte = 1u
val s: UShort = 1u
val l: ULong = 1u

val a1 = 42u // UInt
val a2 = 0xFFFF_FFFF_FFFFu // ULong
```
- `ul` 과 `UL`는 명시적으로 unsigned long 리터럴 태그다.
```kotlin
val a = 1UL
```

## Booleans
`Boolean` 타입은 두 값 `true`, `false`를 가질 수 있는 boolean 객체를 표현한다.
`Boolean` 은 nullable `Boolean?`는 null을 가질 수 있다.

boolean 에 대한 내장된 연산
- `||`: 논리적 OR
- `&&`: 논리적 AND
- `!`: 논리적 NOT

`||` 와 `&&` 는 lazy하게 동작한다.
```kotlin
val myTrue: Boolean = true
val myFalse: Boolean = false
val boolNull: Boolean? = null

println(myTrue || myFalse)
println(myTrue && myFalse)
println(!myTrue)
```
