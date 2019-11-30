#### _Type vs Term_
- `A type is a description of a concept in an application`
	- `A class is a type`
- `A term is a concrete representation of a type`
	- `Any class instance(including an object) is a term` 
	- `A method is a term, as it is also concrete and "callable"`

#### _Calling a Term_
- `Scala allows to "call" a term without specifying the method you want to call on it`
```scala
scala> case class Time(h: Int = 0, m: Int = 0)
defined class Time

scala> val t = Time(10,0)
t: Time = Time(10,0)
```
#### _Apply_
`*When we create a case class, the complier generates a companion object for the class.Calling `_Time(10,0)_` is actually calling the companion object Time and delegating to `_apply()_` method inside of it`
```scala
scala> Time(9,0)
res6: Time = Time(9,0)

scala> Time.apply(9,0)
res7: Time = Time(9,0)

scala> object Reverse {
     |   def apply(s: String): String = {
     |      s.reverse
     |   }
     | }
defined object Reverse

scala> Reverse("Hello, World!")
res8: String = !dlroW ,olleH

scala> Array(1,2,3,4)
res9: Array[Int] = Array(1, 2, 3, 4)

scala> res9(1)
res10: Int = 2

scala> res9.apply(1)
res11: Int = 2
```
#### _Unapply_
- `Unapply deconstruct a Case Class.  To deconstruct `Time case class`,  from that we get a representation of the values that are inside of the time case class`
```scala
scala> val time = Time(11,9)
time: Time = Time(11,9)

scala> Time.unapply(time)
res18: Option[(Int, Int)] = Some((11,9))
```
