```scala

_reduceLeft & reduceRight_

scala> val l = List(1,2,3,4)
l: List[Int] = List(1, 2, 3, 4)

scala> l.sum
res48: Int = 10

scala> l.product
res49: Int = 24

scala> def sum(l: List[Int]): Int = l match {
     | case Nil => 0
     | case x :: xs => x + sum(xs)
     | }
sum: (l: List[Int])Int

scala> sum(l)
res50: Int = 10

scala> def product(l: List[Int]): Int = l match {
     | case Nil => 0
     | case x :: xs => x * product(xs)
     | }
product: (l: List[Int])Int

scala> product(l)
res51: Int = 0

scala> def product(l: List[Int]): Int = l match {
     | case Nil => 1
     | case x :: xs => x * product(xs)
     | }
product: (l: List[Int])Int

scala> product(l)
res52: Int = 24

scala> l.reduceLeft((x,y) => x+y)
res53: Int = 10

scala> l.reduceLeft((x,y) => x*y)
res54: Int = 24

scala> l.reduceLeft((x,y) => if(x > y) x else y)
res63: Int = 4

scala> l
res64: List[Int] = List(1, 2, 3, 4)

scala> l.reduceLeft((x,y) => if(x < y) x else y)
res65: Int = 1

scala> l.reduceRight((x,y) => if(x < y) x else y)
res66: Int = 1

scala> l.reduceRight((x,y) => if(x > y) x else y)
res67: Int = 4

scala> val peeps = Vector("ai", "deep", "learning", "machine")
peeps: scala.collection.immutable.Vector[String] = Vector(ai, deep, learning, machine)

scala> peeps.reduceLeft((x,y) => if(x.length > y.length) x else y)
res68: String = learning

scala> peeps.reduceLeft((x,y) => if(x.length < y.length) x else y)
res69: String = ai

scala> peeps
res72: scala.collection.immutable.Vector[String] = Vector(ai, deep, learning, machine)

scala> l
res73: List[Int] = List(1, 2, 3, 4)

_foldLeft & foldRight_

scala> l.foldLeft(0)((x,y) => if (x > y) x else y)
res75: Int = 4

scala> l.foldLeft(1)((x,y) => if (x > y) x else y)
res76: Int = 4

scala> l.foldLeft(1)((x,y) => x + y)
res77: Int = 11

scala> l.foldLeft(0)((x,y) => x + y)
res78: Int = 10

scala> l.foldLeft(0)((x,y) => x * y)
res79: Int = 0

scala> l.foldLeft(1)((x,y) => x * y)
res80: Int = 24

scala> peeps.foldLeft("ai")((x,y) => if (x.length > y.length) x else y)
res81: String = learning

scala> peeps.foldLeft("ai")((x,y) => if (x.length < y.length) x else y)
res82: String = ai

scala> peeps.foldLeft("machine")((x,y) => if (x.length < y.length) x else y)
res83: String = ai

scala> peeps.foldLeft("machine")((x,y) => if (x.length > y.length) x else y)
res84: String = learning

scala> peeps.foldRight("machine")((x,y) => if (x.length > y.length) x else y)
res85: String = learning

scala> peeps.foldRight("machine")((x,y) => if (x.length < y.length) x else y)
res86: String = ai

_scanLeft & scanRight_
#### scanLeft and scanRight walk through a sequence in a manner similar to foldLeft and foldRight, but the key difference is that they return a sequence rather than a single value.

scala> l
res88: List[Int] = List(1, 2, 3, 4)

scala> l.scanLeft(1)((x,y) => x + y)
res90: List[Int] = List(1, 2, 4, 7, 11)

scala> l.scanLeft(0)((x,y) => x + y)
res91: List[Int] = List(0, 1, 3, 6, 10)

scala> l.scanLeft(0)((x,y) => x * y)
res92: List[Int] = List(0, 0, 0, 0, 0)

scala> l.scanLeft(1)((x,y) => x * y)
res93: List[Int] = List(1, 1, 2, 6, 24)

scala> l.scanRight(1)((x,y) => x * y)
res94: List[Int] = List(24, 24, 12, 4, 1)

scala> l.scanRight(0)((x,y) => x + y)
res95: List[Int] = List(10, 9, 7, 4, 0)

scala> peeps
res96: scala.collection.immutable.Vector[String] = Vector(ai, deep, learning, machine)

scala> peeps.scanLeft("ai")((x,y) => if(x.length > y.length) x else y)
res97: scala.collection.immutable.Vector[String] = Vector(ai, ai, deep, learning, learning)

scala> peeps.scanLeft("ai")((x,y) => if(x.length < y.length) x else y)
res98: scala.collection.immutable.Vector[String] = Vector(ai, ai, ai, ai, ai)

scala> peeps.scanLeft("deep")((x,y) => if(x.length < y.length) x else y)
res99: scala.collection.immutable.Vector[String] = Vector(deep, ai, ai, ai, ai)

scala> peeps.scanLeft("deep")((x,y) => if(x.length > y.length) x else y)
res100: scala.collection.immutable.Vector[String] = Vector(deep, deep, deep, learning, learning)

scala> peeps.scanLeft("machine")((x,y) => if(x.length > y.length) x else y)
res101: scala.collection.immutable.Vector[String] = Vector(machine, machine, machine, learning, learning)

scala> peeps.scanLeft("machine")((x,y) => if(x.length < y.length) x else y)
res102: scala.collection.immutable.Vector[String] = Vector(machine, ai, ai, ai, ai)

```