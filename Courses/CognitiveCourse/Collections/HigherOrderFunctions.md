#### _Higher Order Functions_
- `A Functions which takes another function`
- `To describe the "how" for work to be done in a container`
- `The function passed to it describes the "what" that should be done to elements in the container`

##### map
```scala
scala> 1 to 5
res24: scala.collection.immutable.Range.Inclusive = Range 1 to 5

scala> res24.map(n => n + 1)
res26: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 4, 5, 6)

scala> res24.map(_ + 1)
res27: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 4, 5, 6)
```

##### flatMap
```scala
scala> List("Scala", "Python", "R")
res28: List[String] = List(Scala, Python, R)

scala> res28.map(l => l + "#")
res29: List[String] = List(Scala#, Python#, R#)

scala> res28.flatMap(l => l + "#")
res30: List[Char] = List(S, c, a, l, a, #, P, y, t, h, o, n, #, R, #)
```

##### filter
```scala
scala> List("Scala", "Python", "R", "SQL")
res31: List[String] = List(Scala, Python, R, SQL)

scala> res31.filter(l => l.contains("S"))
res33: List[String] = List(Scala, SQL)

scala> res31.filter(l => l.contains("A"))
res34: List[String] = List()

scala> res31.filter(l => l.contains("A".toLowerCase))
res36: List[String] = List(Scala)
```

##### foreach
```scala
scala> res31.filter(l => l.contains("S"))
res37: List[String] = List(Scala, SQL)

scala> res31.map(println)
Scala
Python
R
SQL
res38: List[Unit] = List((), (), (), ())

scala> res31.foreach(println)
Scala
Python
R
SQL
```

##### forall
```scala
scala> List("Scala", "Simple", "Stellar")
res45: List[String] = List(Scala, Simple, Stellar)

scala> res45.forall(l => l.contains("s"))
res46: Boolean = false

scala> res45.forall(l => l.contains("S"))
res47: Boolean = true
```

##### reduce
```scala
scala> 1 to 5
res48: scala.collection.immutable.Range.Inclusive = Range 1 to 5

scala> res48.reduce((acc, cur) => acc + cur)
res49: Int = 15

scala> res48.reduce(_ + _)
res50: Int = 15

scala> List[Int]().reduce((acc, cur) => acc + cur)
java.lang.UnsupportedOperationException: empty.reduceLeft
```

##### reduce => fold, foldLeft, foldRight
```scala
scala> List[Int]().foldLeft(0){case(acc, cur) => acc + cur}
res56: Int = 0

scala> List[Int]().foldRight(0){case(acc, cur) => acc + cur}
res57: Int = 0

scala> 1 to 5
res48: scala.collection.immutable.Range.Inclusive = Range 1 to 5

scala> res48.foldRight(0){case(acc, cur) => acc + cur}
res58: Int = 15

scala> res48.foldLeft(0){case(acc, cur) => acc + cur}
res59: Int = 15
```

##### product
```scala
scala> res48.product
res60: Int = 120

##### exists
scala> res48.exists(n => n == 3)
res61: Boolean = true

scala> res48.exists(n => n == 6)
res62: Boolean = false

##### find
scala> res48.find(n => n == 6)
res63: Option[Int] = None

scala> res48.find(n => n == 3)
res64: Option[Int] = Some(3)
```

##### groupBy
```scala
scala> res48.groupBy(n => n % 3)
res65: scala.collection.immutable.Map[Int,scala.collection.immutable.IndexedSeq[Int]] = Map(2 -> Vector(2, 5), 1 -> Vector(1, 4), 0 -> Vector(3))

scala> res48.groupBy(n => n % 2)
res66: scala.collection.immutable.Map[Int,scala.collection.immutable.IndexedSeq[Int]] = Map(1 -> Vector(1, 3, 5), 0 -> Vector(2, 4))

##### takeWhile
scala> 1.to(10)
res78: scala.collection.immutable.Range.Inclusive = Range 1 to 10

scala> res78.takeWhile(n => n < 4)
res81: scala.collection.immutable.Range = Range 1 to 3

scala> res78.takeWhile(n => n < 4).foreach(println)
1
2
3
```

##### dropWhile
```scala
scala> 1.to(10)
res78: scala.collection.immutable.Range.Inclusive = Range 1 to 10

scala> res78.dropWhile(n => n < 4)
res82: scala.collection.immutable.Range = Range 4 to 10

scala> res78.dropWhile(n => n < 4).foreach(println)
4
5
6
7
8
9
10
```



