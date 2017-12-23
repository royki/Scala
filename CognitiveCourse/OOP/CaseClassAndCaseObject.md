#### _Data Class_
- `Some classes represent specific data types in a "domain"`
- `Exmp - Customers, Accounts, Orders, Inventory`

#### _Service Class_
- `Some classes represent work to be performed in an application`
- `They know what to do, but they don't hold the data themselves`
- `When an application calls the service, they pass the data to the service, and the service transforms it in some way`
- `Exmp - Persistence, Loggers, Calculation engines`


#### _Case Class_
- `A representation of data types that removes a lot of boilerplate code`
- `Generates JVM-specific convenience methods`
- `Makes every class parameter a field`
- `Is immutable by default`
- `Performs value-based equivalence by default`

```scala
scala> case class Time(h: Int = 0, m: Int = 0)
defined class Time

scala> Time(9)
res0: Time = Time(9,0)

scala> val t = Time(10)
t: Time = Time(10,0)

scala> t == Time(9)
res1: Boolean = false

scala> t == Time(10,0)
res2: Boolean = true

scala> t.m
res3: Int = 0

scala> t.h
res4: Int = 10
```

#### _Case Objects_
- `If a case class is an instance-based representation of a data type, case object is a representation of a
data type of which there can only be a single instance`
- `If you try to create a case class with no parameters, it is stateless and should be a case object`

```scala
scala> case class Time1
<console>:1: error: case classes must have a parameter list; try 'case class Time1()' or 'case object Time1'
       case class Time1
                       ^

scala> case object Time1
defined object Time1

scala> Time1.toString
res5: String = Time1
```
