#### _Synthetic Methods_
- `Scala's compiler generate "boilerplate" at compile time`
- `The implementations are solid and proven`
	- `equals()`
	- `hasCode()`
	- `toString()`
	- `copy()`

#### _equals()_	
- `This method is required by the JVM, but the default implementation only compares whether an instance of the class is the exact same instance`
- `Scala provides value-based equivalence, allowing to compare whether two different instances of a class have the same state`

```scala
scala> case class Fruit(f:String = "", n:Int = 0)
defined class Fruit

scala> val fruit = Fruit("Mango", 15)
fruit: Fruit = Fruit(Mango,15)

scala> fruit == Fruit(15)
<console>:15: error: type mismatch;
 found   : Int(15)
 required: String
       fruit == Fruit(15)
                      ^
scala> fruit == Fruit("Mango")
res20: Boolean = false

scala> fruit == Fruit("Mango",15)
res21: Boolean = true

scala> fruit == Fruit("Mango",16)
res22: Boolean = false
```

#### _hashCode()_
- `This methof is required for any class that we might want to put into a hashed collection, such as a HashMap or HashSet`
```scala
scala> Fruit("Banana", 20).hashCode()
res23: Int = -1994345621
```
#### _toString()_
- `This method is required by the JVM, but the default implementation prints out a virtual representation of the instance location in memory`
- `The synthetic `toString()` provided by Scala's case class shows the values inside of the class`
- `We can override this to make it better`

```scala
scala> class Books(n: String = " ", isbn: Int = 0)
defined class Books

scala> new Books()
res24: Books = Books@1dd8774c

scala> case class Books(n: String = " ", isbn: Int = 0)
defined class Books

scala> Books
res25: Books.type = Books

scala> Books()
res26: Books = Books( ,0)
```
#### _copy()_
- `This method is not required by the JVM`
- `The synthetic `copy()` provided by Scala's case class allow to remain immutable and use "snapshots" of the case classes when state needs to change. It will create a new instance of whatever classes are defined with all the same values except for those that are changed when it is said to make the copy`

```scala
scala> var book = Books("To Kill A Mocking Bird", 2312)
book: Books = Books(To Kill A Mocking Bird,2312)

scala> book = book.copy(isbn = 2313)
book: Books = Books(To Kill A Mocking Bird,2313)

scala> val bookImmutable = Books("Scala", 2314)
book: Books = Books(Scala,2314)

scala> bookImmutable = bookImmutable.copy(2315)
<console>:12: error: reassignment to val
       bookImmutable = bookImmutable.copy(2315)
            ^
```