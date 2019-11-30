#### _Vector_
```scala

scala> val f10 = (1 to 10).toVector
f10: Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

scala> f10.partition(x => x > 3)
res106: (scala.collection.immutable.Vector[Int], scala.collection.immutable.Vector[Int]) = (Vector(4, 5, 6, 7, 8, 9, 10),Vector(1, 2, 3))

scala> l.partition(x => x > 2)
res107: (List[Int], List[Int]) = (List(3, 4),List(1, 2))

scala> f10.span(x => x > 3)
res108: (scala.collection.immutable.Vector[Int], scala.collection.immutable.Vector[Int]) = (Vector(),Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

scala> f10.span(x => x < 3)
res109: (scala.collection.immutable.Vector[Int], scala.collection.immutable.Vector[Int]) = (Vector(1, 2),Vector(3, 4, 5, 6, 7, 8, 9, 10))

scala> f10.sliding(2)
res110: Iterator[scala.collection.immutable.Vector[Int]] = non-empty iterator

scala> f10.sliding(2).toVector
res111: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(2, 3), Vector(3, 4), Vector(4, 5), Vector(5, 6), Vector(6, 7), Vector(7, 8), Vector(8, 9), Vector(9, 10))

scala> l.sliding(2)
res112: Iterator[List[Int]] = non-empty iterator

scala> l.sliding(2).toList
res113: List[List[Int]] = List(List(1, 2), List(2, 3), List(3, 4))

scala> f10.sliding(3,4).toVector
res114: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2, 3), Vector(5, 6, 7), Vector(9, 10))

scala> f10.sliding(2,2).toVector
res115: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(3, 4), Vector(5, 6), Vector(7, 8), Vector(9, 10))

scala> f10.sliding(2).toVector
res116: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(2, 3), Vector(3, 4), Vector(4, 5), Vector(5, 6), Vector(6, 7), Vector(7, 8), Vector(8, 9), Vector(9, 10))

scala> f10.sliding(3,2).toVector
res117: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2, 3), Vector(3, 4, 5), Vector(5, 6, 7), Vector(7, 8, 9), Vector(9, 10))

scala> f10.sliding(3).toVector
res118: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2, 3), Vector(2, 3, 4), Vector(3, 4, 5), Vector(4, 5, 6), Vector(5, 6, 7), Vector(6, 7, 8), Vector(7, 8, 9), Vector(8, 9, 10))

scala> f10.groupBy(x => x > 4)
res119: scala.collection.immutable.Map[Boolean,scala.collection.immutable.Vector[Int]] = Map(false -> Vector(1, 2, 3, 4), true -> Vector(5, 6, 7, 8, 9, 10))

scala> f10.groupBy(x => x < 4)
res120: scala.collection.immutable.Map[Boolean,scala.collection.immutable.Vector[Int]] = Map(false -> Vector(4, 5, 6, 7, 8, 9, 10), true -> Vector(1, 2, 3))

scala> f10.grouped(2)
res121: Iterator[scala.collection.immutable.Vector[Int]] = non-empty iterator

scala> f10.grouped(2).toVector
res122: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(3, 4), Vector(5, 6), Vector(7, 8), Vector(9, 10))

scala> f10.grouped(2).toVector.flatten
res123: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

scala> f10.grouped(2).toVector
res124: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(3, 4), Vector(5, 6), Vector(7, 8), Vector(9, 10))           

scala> f10.sliding(2,2).toVector
res126: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(3, 4), Vector(5, 6), Vector(7, 8), Vector(9, 10))

scala> f10.sliding(2).toVector
res127: Vector[scala.collection.immutable.Vector[Int]] = Vector(Vector(1, 2), Vector(2, 3), Vector(3, 4), Vector(4, 5), Vector(5, 6), Vector(6, 7), Vector(7, 8), Vector(8, 9), Vector(9, 10))

scala> f10.zipWithIndex.sliding(1).toVector
res131: Vector[scala.collection.immutable.Vector[(Int, Int)]] = Vector(Vector((1,0)), Vector((2,1)), Vector((3,2)), Vector((4,3)), Vector((5,4)), Vector((6,5)), Vector((7,6)), Vector((8,7)), Vector((9,8)), Vector((10,9)))
```