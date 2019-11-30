##### _JVM Exceptions_
- `JVM represents runtime failure for various reason`
    - `NullPointerException (Runtime)`
    - `ClassCastException (Runtime)`
    - `IOException (Checked)`
    - `When one occurs, control is "thrown" back within a thread stack to whomever "catches" it`

```scala
scala> def toInt(s: String):Int = {
     |   try {
     |      s.toInt
     |   } catch {
     |      case _: NumberFormatException => 0
     |   }
     | }
toInt: (s: String)Int

scala> toInt("sd")
res0: Int = 0

scala> toInt("s")
res1: Int = 0

scala> toInt("10")
res2: Int = 10  
```
#### _Idiomatic Scala and Exceptions_
##### Scala handles exceptions in different approach, as the above exception handling represents possible "side effect"
- `In Scala, everything in the code to be pure i.e functional and no side-effect`
- `Scala interact with libraries or services that may fail, it "wrap" the call in a "Try" to capture the failure`

###### _Wrapping a Call in_ `Try`
- `In success case, we get Success just like Option`
- `In failed case, we get a Failure representing the exception itself without going up the thread stack`
```scala
scala> import scala.util.{Try, Success, Failure}
import scala.util.{Try, Success, Failure}

scala> Try("100".toInt)
res3: scala.util.Try[Int] = Success(100)

scala> Try("Scala".toInt)
res4: scala.util.Try[Int] = Failure(java.lang.NumberFormatException: For input string: "Scala")"
```
###### _Pattern Matching on Try and deconstruct the possible value_
```scala
scala>  def makeInt(s: String): Int = Try(s.toInt) match {
     |     case Success(n) => n
     |     case Failure(_) => 0
     | }
makeInt: (s: String)Int

scala> makeInt("35")
res5: Int = 35

scala> makeInt("Akka")
res6: Int = 0
```
###### _Higher Order Functions and Try_
```scala
**Success Case
scala> def getScala: Try[String] = Success("Scala")
getScala: scala.util.Try[String]

scala> val scala: Try[String] = Success("Scala")
scala: scala.util.Try[String] = Success(Scala)

scala> scala.map(s => s.reverse)
res7: scala.util.Try[String] = Success(alacS)

**Failure Case
scala> def getFailure: Try[String] = Failure(new Exception("Failed"))
getFailure: scala.util.Try[String]

scala> val failed = getFailure
failed: scala.util.Try[String] = Failure(java.lang.Exception: Failed)

scala> failed.map(s => s.reverse)
res8: scala.util.Try[String] = Failure(java.lang.Exception: Failed)
```

###### _For Expressions and Try_
```scala
scala> Success("Scala").map(_.reverse)
res10: scala.util.Try[String] = Success(alacS)

scala> for {
     |   language <- Success("Scala")
     |   behavior <- Success("Akka")
     | } yield s"$language $behavior"
res11: scala.util.Try[String] = Success(Scala Akka)

scala> for {
     |   language <- Success("Scala")
     |   behavior <- Failure( new Exception("Akka"))
     | } yield s"$language $behavior"
res13: scala.util.Try[String] = Failure(java.lang.Exception: Akka)
```
