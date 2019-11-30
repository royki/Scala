- IndexdSeq - provides fast random-access of elements and a fast length operation
- LinearSeq - provides fast access only to the first element via head, but also has a fast tail operation
- Seq behaves differently than Vector

```scala

val nums = Seq(1,2,3)

case class Person(name: String)

val people = Seq(Person("Emily"), Person("Hannah"), Person("Alvin"))

val x = Seq(1, 1.0,1F) // x: Seq[Double] = List(1.0, 1.0, 1.0)
val x:Seq[Number] = Seq(1, 1.0,1F) // x: Seq[Number] = List(1.0, 1.0, 1.0)

trait Animal
case class Dog(name: String) extends Animal
case class Cat(name: String) extends Animal

val animalHouse: Seq[Animal] = Seq(Dog("Rover"), Cat("Felix"))

scala> val n = Seq[Animal]()
n: Seq[Animal] = List()

scala> val n = Seq[Int]()
n: Seq[Int] = List()

scala> val n = List[Int]()
n: List[Int] = List()

scala> val n = List[Animal]()
n: List[Animal] = List()
```
#### _Create a new Seq by populting it (with Array and List)_
```scala
scala> (1 to 5).toList
res0: List[Int] = List(1, 2, 3, 4, 5)

scala> (1 to 5).toArray
res1: Array[Int] = Array(1, 2, 3, 4, 5)

scala> (1 to 5).toSeq
res2: scala.collection.immutable.Range = Range 1 to 5

scala> (1 until 5).toArray
res3: Array[Int] = Array(1, 2, 3, 4)

scala> (1 until 5).toList
res4: List[Int] = List(1, 2, 3, 4)

scala> (1 until 5).toSeq
res5: scala.collection.immutable.Range = Range 1 until 5

scala> (1 to 10 by 2).toArray
res6: Array[Int] = Array(1, 3, 5, 7, 9)

scala> (1 to 10 by 2).toList
res7: List[Int] = List(1, 3, 5, 7, 9)

scala> (1 to 10 by 2).toSeq
res8: scala.collection.immutable.Range = inexact Range 1 to 10 by 2

scala> Seq.range(1,5)
res9: Seq[Int] = List(1, 2, 3, 4)

scala> Array.range(1,5)
res10: Array[Int] = Array(1, 2, 3, 4)

scala> List.range(1,5)
res11: List[Int] = List(1, 2, 3, 4)

scala> Seq.range(1,10, 2)
res12: Seq[Int] = List(1, 3, 5, 7, 9)

scala> Array.range(1,10, 2)
res13: Array[Int] = Array(1, 3, 5, 7, 9)

scala> List.range(1,10, 2)
res14: List[Int] = List(1, 3, 5, 7, 9)

scala> Seq.fill(3)(10)
res19: Seq[Int] = List(10, 10, 10)

scala> Array.fill(3)(10)
res20: Array[Int] = Array(10, 10, 10)

scala> List.fill(3)(10)
res21: List[Int] = List(10, 10, 10)

scala> Seq.tabulate(3)(n => n * n)
res23: Seq[Int] = List(0, 1, 4)

scala> Seq.tabulate(4)(n => n * n)
res24: Seq[Int] = List(0, 1, 4, 9)

scala> Array.tabulate(4)(n => n * n)
res25: Array[Int] = Array(0, 1, 4, 9)

scala> List.tabulate(4)(n => n * n)
res26: List[Int] = List(0, 1, 4, 9)

scala> List.tabulate(4)(n => n + n)
res27: List[Int] = List(0, 2, 4, 6)

scala> List.tabulate(4)(n => n + 1)
res28: List[Int] = List(1, 2, 3, 4)

scala> List.tabulate(4)(n => n + 1)
res29: List[Int] = List(1, 2, 3, 4)
```

#### _IndexedSeq and LinearSeq Return Type_

```scala
scala> import scala.collection._
import scala.collection._

scala> val num = IndexedSeq(1,2,3)
num: IndexedSeq[Int] = Vector(1, 2, 3) // IndexedSeq returns a Vector

scala> val nums = LinearSeq(1,2,3)
nums: scala.collection.LinearSeq[Int] = List(1, 2, 3) // LinearSeq returns a List
```

#### _Append/Prepend elements to a Seq (Seq is immutable)_

```scala
/*

:+ append 1 item
++ append N items
+: prepend 1 item
++: prepend N items

** During these operations the ':' character is always next to the old(original sequence)
*/

scala> val v1 = Seq(4,5,6)
v1: Seq[Int] = List(4, 5, 6)

scala> val v2 = v1 :+ 7
v2: Seq[Int] = List(4, 5, 6, 7)

scala> val v3 = v2 ++ Seq(8,9)
v3: Seq[Int] = List(4, 5, 6, 7, 8, 9)

scala> val v4 = v2 ++ List(8,9) // Check with List
v4: Seq[Int] = List(4, 5, 6, 7, 8, 9)

scala> val v5 = 3 +: v3
v5: Seq[Int] = List(3, 4, 5, 6, 7, 8, 9)                           

scala> val v6 = Seq(1,2) ++: v5
v6: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
```

#### _Filtering methods (remove elements from a Seq)_
- Standart method proivded by Scala lib for filtering in Seq (List, Array)
	- `distinct, head, headOption, tail, init, last, lastOption, drop, dropRight, dropWhile, take, takeWhile, takeRight, filter, filtetNot, find, intersect`
 
```scala
scala> val a = Seq(20,44,55,12,5,10)
a: Seq[Int] = List(20, 44, 55, 12, 5, 10)

scala> a.distinct
res32: Seq[Int] = List(20, 44, 55, 12, 5, 10)

scala> a ++ Seq(6,7,5,10,66,55)
res33: Seq[Int] = List(20, 44, 55, 12, 5, 10, 6, 7, 5, 10, 66, 55)

scala> a.distinct
res34: Seq[Int] = List(20, 44, 55, 12, 5, 10)

scala> a.drop(2)
res35: Seq[Int] = List(55, 12, 5, 10)

scala> a.dropRight(2)
res36: Seq[Int] = List(20, 44, 55, 12)

scala> a.dropWhile(_ < 25)
res37: Seq[Int] = List(44, 55, 12, 5, 10)

scala> a.dropWhile(x => x < 25)
res38: Seq[Int] = List(44, 55, 12, 5, 10)

scala> a.filter(x => x < 25)
res39: Seq[Int] = List(20, 12, 5, 10)

scala> a.dropWhile(x => x > 25)
res40: Seq[Int] = List(20, 44, 55, 12, 5, 10)

scala> a.filter(x => x > 25)
res41: Seq[Int] = List(44, 55)

scala> a.find(x => x%2 == 0)
res42: Option[Int] = Some(20)

scala> a.find(x => x > 20)
res43: Option[Int] = Some(44)

scala> a.filterNot(x => x > 25)
res44: Seq[Int] = List(20, 12, 5, 10)

scala> a.filter(x => x < 25)
res45: Seq[Int] = List(20, 12, 5, 10)

scala> a.head
res46: Int = 20

scala> a.headOption
res47: Option[Int] = Some(20)

scala> a.init
res48: Seq[Int] = List(20, 44, 55, 12, 5)

scala> a.intersect(Seq(10,15,20,25))
res49: Seq[Int] = List(20, 10)

scala> a.last
res50: Int = 10

scala> a.lastOption
res51: Option[Int] = Some(10)

scala> a.slice(2,4)
res52: Seq[Int] = List(55, 12)

scala> a.tail
res53: Seq[Int] = List(44, 55, 12, 5, 10)

scala> a.tail.init
res54: Seq[Int] = List(44, 55, 12, 5)

scala> a.init
res55: Seq[Int] = List(20, 44, 55, 12, 5)

scala> a.take(3)
res56: Seq[Int] = List(20, 44, 55)

scala> a.drop(3)
res57: Seq[Int] = List(12, 5, 10)

scala> a
res58: Seq[Int] = List(20, 44, 55, 12, 5, 10)

scala> a.dropRight(3)
res59: Seq[Int] = List(20, 44, 55)

scala> a.takeRight(3)
res60: Seq[Int] = List(12, 5, 10)

scala> a.takeWhile(x => x < 25)
res61: Seq[Int] = List(20)

scala> a.takeWhile(x => x > 25)
res62: Seq[Int] = List()

scala> a.takeWhile(x => x > 15)
res63: Seq[Int] = List(20, 44, 55)

scala> a.takeWhile(x => x > 4)
res64: Seq[Int] = List(20, 44, 55, 12, 5, 10)

scala> a.dropWhile(x => x > 4)
res65: Seq[Int] = List()

scala> a.dropWhile(x => x > 20)
res66: Seq[Int] = List(20, 44, 55, 12, 5, 10)
```

#### _Update Seq elements_

- Standard method proivded by Scala lib to update Seq elements
	- collect(pf), distinct, flatten, flatMap, map(f), updated(i,v) union(s)

```scala
scala> val x = Seq(Some(1), None, Some(3), None)
x: Seq[Option[Int]] = List(Some(1), None, Some(3), None)

scala> x.collect {
     | case Some(i) => i
     | case None => None
     | }
res1: Seq[Any] = List(1, None, 3, None)

scala> x.collect {
     | case None => None
     | }
res2: Seq[None.type] = List(None, None)

scala> x.collect {
     | case Some(i) => i
     | }
res3: Seq[Int] = List(1, 3)


scala> val y = Seq(1,2,1,2)
y: Seq[Int] = List(1, 2, 1, 2)

scala> y.distinct
res4: Seq[Int] = List(1, 2)

scala> y.map(_ * 2)
res6: Seq[Int] = List(2, 4, 2, 4)

scala> y.map(x => x * 2)
res7: Seq[Int] = List(2, 4, 2, 4)

scala> y.updated(0,100)
res8: Seq[Int] = List(100, 2, 1, 2)

scala> val a = Seq(Seq(1,2), Seq(3,4))
a: Seq[Seq[Int]] = List(List(1, 2), List(3, 4))

scala> a.flatten
res9: Seq[Int] = List(1, 2, 3, 4)

scala> val fruits = Seq("apple", "pear")
fruits: Seq[String] = List(apple, pear)

scala> fruits.map(f => f.toUpperCase)
res10: Seq[String] = List(APPLE, PEAR)

scala> fruits.map(_.toUpperCase)
res11: Seq[String] = List(APPLE, PEAR)

scala> fruits.flatMap(_.toUpperCase)
res12: Seq[Char] = List(A, P, P, L, E, P, E, A, R)

scala> fruits.map(f => f)
res13: Seq[String] = List(apple, pear)

scala> fruits.map(f => f.split(","))
res14: Seq[Array[String]] = List(Array(apple), Array(pear))
```

#### _Transformer Methods_
- A transformer method is a method that constructs a new collection from an existing collection.

```scala
scala> val oneToFive = (1 to 5).toSeq
oneToFive: scala.collection.immutable.Range = Range 1 to 5

scala> val threeToSevem = (3 to 7).toSeq
threeToSevem: scala.collection.immutable.Range = Range 3 to 7

scala> oneToFive.diff(threeToSevem)              
res20: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2)

scala> threeToSevem.diff(oneToFive)
res21: scala.collection.immutable.IndexedSeq[Int] = Vector(6, 7)

scala> val a = Seq(Seq(1,2), Seq(3,4))
a: Seq[Seq[Int]] = List(List(1, 2), List(3, 4))

scala> a.flatten
res22: Seq[Int] = List(1, 2, 3, 4)

scala> val l = List(List(1,2), List(3,2))
l: List[List[Int]] = List(List(1, 2), List(3, 2))

scala> l.flatten
res26: List[Int] = List(1, 2, 3, 2)

scala> Seq(4,21,5).reverse
res27: Seq[Int] = List(5, 21, 4)

scala> val fruits = Seq("apple", "pear")
fruits: Seq[String] = List(apple, pear)

scala> val fruits = Seq("Amm", "Jamm")
fruits: Seq[String] = List(Amm, Jamm)

scala> val fruits = Seq("Amm", "Jamm", "Kathal")
fruits: Seq[String] = List(Amm, Jamm, Kathal)

scala> fruits.map(x => x.toUpperCase)
res28: Seq[String] = List(AMM, JAMM, KATHAL)

scala> fruits.map(x => x.toLowerCase)
res30: Seq[String] = List(amm, jamm, kathal)

scala> fruits.flatMap(x => x.toLowerCase)
res31: Seq[Char] = List(a, m, m, j, a, m, m, k, a, t, h, a, l)

scala> fruits.flatMap(x => x.toUpperCase)
res32: Seq[Char] = List(A, M, M, J, A, M, M, K, A, T, H, A, L)

scala> val xnums = Seq(10, 5, 8, 1, 7)
xnums: Seq[Int] = List(10, 5, 8, 1, 7)

scala> xnums.sorted
res33: Seq[Int] = List(1, 5, 7, 8, 10)

scala> xnums.sortWith((x,y) => x > y)
res35: Seq[Int] = List(10, 8, 7, 5, 1)

scala> xnums.sortWith((x,y) => x < y)
res36: Seq[Int] = List(1, 5, 7, 8, 10)

scala> xnums.sortWith(_ > _)
res37: Seq[Int] = List(10, 8, 7, 5, 1)

scala> xnums.sortWith(_ < _)
res38: Seq[Int] = List(1, 5, 7, 8, 10)

scala> Seq(1,2,3).updated(0,10)
res39: Seq[Int] = List(10, 2, 3)

scala> res39.updated(4,100)
java.lang.IndexOutOfBoundsException: 4
  at scala.collection.SeqLike.updated(SeqLike.scala:549)
  at scala.collection.SeqLike.updated$(SeqLike.scala:540)
  at scala.collection.AbstractSeq.updated(Seq.scala:41)
  ... 28 elided

scala> res39.updated(1,100)
res41: Seq[Int] = List(10, 100, 3)

scala> val women = Seq("Wilma", "Betty")
women: Seq[String] = List(Wilma, Betty)

scala> val men = Seq("Fred", "Barney")
men: Seq[String] = List(Fred, Barney)

scala> val couples = women.zip(men)
couples: Seq[(String, String)] = List((Wilma,Fred), (Betty,Barney))

scala> val couples = men.zip(women)
couples: Seq[(String, String)] = List((Fred,Wilma), (Barney,Betty))

scala> val ar = Seq.range('a', 'h')
ar: Seq[Char] = List(a, b, c, d, e, f, g)

scala> ar.zipWithIndex
res42: Seq[(Char, Int)] = List((a,0), (b,1), (c,2), (d,3), (e,4), (f,5), (g,6))

```