#### _Futures_
- `Allow us to define work that may happen at some later time, possibly on another thread.`
- `Futures return a Try of whether or not the work was successfully completed.`

###### _ExecutionContext_
- `To use a Future, we must provide a thread pool that the Future can use to perfomr the work.`
 - `For example - We can use `implicit val` to declare it one time and automatically apply it to all usages within a scope. So rather than having to provide an execution context to every single one of the Futures explicitly, we can define it one time using this implicit val and then it can be used for all Futures inside of that block of code.`
```scala
ExecutionContext example
scala> import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext

scala> import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinPool

scala> implicit val ec: ExecutionContext = ExecutionContext.fromExecutor(new ForkJoinPool())
ec: scala.concurrent.ExecutionContext = scala.concurrent.impl.ExecutionContextImpl@7e1a9173
```
###### _Timeout_
- `Futures can have a defined amount of time before they "time out" or fail because they have take too long to do their work or be scheduled. By default Scala has 3 sec of time out. We can override this, using Scala DSL for creating time-based values. Scala has a nice DSL for creating such time-based values`
```scala
Timeout example
scala> import scala.concurrent.duration._
import scala.concurrent.duration._

scala> implicit val timeout = 1 second
<console>:17: warning: postfix operator second should be enabled
by making the implicit value scala.language.postfixOps visible.
This can be achieved by adding the import clause 'import scala.language.postfixOps'
or by setting the compiler option -language:postfixOps.
See the Scaladoc for value scala.language.postfixOps for a discussion
why the feature should be explicitly enabled.
       implicit val timeout = 1 second
                                ^
timeout: scala.concurrent.duration.FiniteDuration = 1 second

The imports that are required to use Fututes, include following list - 
import scala.concurrent.Future
import scala.concurrent.ExecutionContext._
import java.util.concurrent.ForkJoinPool
import scala.util.Failure
import scala.util.Success
import scala.concurrent.duration._ 

scala> import scala.concurrent.Future
import scala.concurrent.Future

scala> import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext

scala> import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinPool

scala> import scala.util.Failure
import scala.util.Failure

scala> import scala.util.Success
import scala.util.Success

scala> import scala.concurrent.duration._
import scala.concurrent.duration._
```
###### To create a Future that we merely define a value that we want to have as a Future of some type, like an integer or a string or a customer. 
```scala
Wrapping a Call in a Future
val f: Future[Int]: Future {
    inventoryService.getCurrentInventory(11232423L)
}
```

###### _Patter Matching on Future_
- `We can pattern match on the result of a Future`
```scala
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success
import scala.concurrent.duration._ 


scala> val f: Future[Int] = Future { 1 + 2 + 3 }
f: scala.concurrent.Future[Int] = Future(Success(6))

scala> f.onComplete {
     |    case Success(i) => println("onComplete Success " +i)
     |    case Failure(f) => println("onComplete Failure " +f)
     | }

scala> onComplete Success 6
```

###### _Higher Order Functions and Futures_
```scala
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success
import scala.concurrent.duration._ 
scala> val g: Future[Int] = Future { 2 + 8 - 7 }
g: scala.concurrent.Future[Int] = Future(<not completed>)

scala> g.map(result => println("Mapping: "+result))
Mapping: 3
res3: scala.concurrent.Future[Unit] = Future(<not completed>)

scala> g.onComplete {
     |    case Success(s) => println(s)
     |    case Failure(f) => println(f)
     | }

scala> 3

Using Thread.sleep()

scala> val g1: Future[Int] = Future { Thread.sleep(4000); 5}
g1: scala.concurrent.Future[Int] = Future(<not completed>)

scala> g1.map(result => println("Mapping "+result))
Mapping 5
res5: scala.concurrent.Future[Unit] = Future(<not completed>)
```

##### _For Expressions and Futures_
```scala
val usdQuote = Future {
    connection.getCurrentValue(USD)
}

val inrQuote = Future {
    connection.getCurrentValue(INR)
}

val purchase = for {
    usd <- usdQuote
    inr <- inrQuote if isProfitable(usd, inr)
} yield connection.buy(amount, inr)
```