##### _Pattern Matching_
- `Many languages have the concept of 'switch/case'`
- `Pattern Matching is similar, but can be applied across many differnt types of data`
- `Can be embedded within other expressions as a way of cleanly expressing conditional logic`
```scala
def isCustomer(someValue: Any): Boolean = {
    someValue match {
        case cust: Author => true
        case _ => false
    }
}

scala> case class Author(fname: String = " ", lname: String = " ")
defined class Author

scala> isCustomer(author)
res0: Boolean = true

scala> isCustomer("Martin Odersky")
res1: Boolean = false
```
- `Pattern Matching is flexible`
    - `Literal values, like "12:00"`
    - `Use guard conditions to be more specific`
    - `Match n only some parts of a value`
    - `More specific cases must come first, more general last`
    - `If we use "_" or simple name with no type, both match on eveything`

- `Exhaustiveness`    
    - `When we see the "case" keyword, pattern matching is in play`
    - `Case classes and ADTs provide compile-time exhaustiveness checking that all possible conditions have been met`

##### Pattern Matching Tuple Values

```scala
scala> val tuple = (1, "a", 2, 'c')
tuple: (Int, String, Int, Char) = (1,a,2,c)

scala> tuple._3
res12: Int = 2

scala> tuple._4
res13: Char = c

scala> tuple._5
<console>:13: error: value _5 is not a member of (Int, String, Int, Char)
       tuple._5
             ^

scala> val (f, s, t, fo) = tuple
f: Int = 1
s: String = a
t: Int = 2
fo: Char = c

scala> val (f, s, t, fo, fi) = tuple
<console>:16: error: constructor cannot be instantiated to expected type;
 found   : (T1, T2, T3, T4, T5)
 required: (Int, String, Int, Char)
       val (f, s, t, fo, fi) = tuple
           ^
```

##### Pattern Matching HOF Arguments
```scala
scala> 1 to 5
res15: scala.collection.immutable.Range.Inclusive = Range 1 to 5

scala> res15.reduce((acc, cur) => acc + cur)
res16: Int = 15

scala> res15.foldLeft(0){case (acc, cur) => acc + cur}
res18: Int = 15
```

##### Option with HOFs
```scala
scala> Option("Martin")
res34: Option[String] = Some(Martin)

scala> res34.map(name => println("Hi," + name))
Hi,Martin
res35: Option[Unit] = Some(())

scala> res34.foreach(name => println("Hi," + name))
Hi,Martin

scala> None.foreach(name => println("Hi," + name))
`Nothing here to output`
scala> Option(None)
res41: Option[None.type] = Some(None)

scala> res41.foreach(a => println("Hi," + a))
Hi,None
```

##### `for` expression and `Option`
```scala
scala> val scala = Option("Scala")
martin: Option[String] = Some(Scala)

scala> val akka = Option("Akka")
jane: Option[String] = Some(Akka)

scala> for {
     |   s <- scala
     |   a <- akka
     | } yield (s + " is friend with " + a)
res43: Option[String] = Some(Scala is friend with Akka)

scala> val noValue = None
noValue: None.type = None

scala> for {
     |   s <- scala
     |   n <- noValue
     | } yield (s +" is friend with "+ n)
res44: Option[String] = None
```
