# 기본 타입
코틀린에서 어떤 변수에서든 멤버 함수와 프로퍼티를 호출할수 있다는 점에서 모든것은 객체입니다.
몇몇 타입은 특수한 내부 표현을 가질수 있다.
예를 들어 numbers, characters 그리고 booleans 는 런타임에서 원시 타입으로 표시될 수 있다.
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

값이 `Float` 타입임을 명시적으로 지정하기 위해서는 접미사 `f` 혹은 `F`를 추가한다. 만약 값에 6-7 자리수 이상 포함된다면, 반올림 됩니다. (rounded 반올림)
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
